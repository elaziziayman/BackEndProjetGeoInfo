package ma.ehtp.projet_geoinfo.web;

import jakarta.persistence.Tuple;
import ma.ehtp.projet_geoinfo.custom.CommuneCount;
import ma.ehtp.projet_geoinfo.custom.PdfToBase64Converter;
import ma.ehtp.projet_geoinfo.custom.UpdateStatutRequest;
import ma.ehtp.projet_geoinfo.entities.*;
import ma.ehtp.projet_geoinfo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:19006", "http://localhost:3000"})
public class DemandeRestService {
    @Autowired
    private DemandeRepository demanderepository;
    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;




    @Autowired
    private AutorisationRepository autorisationRepository;

    @Autowired
    private OccupationRepository occupationRepository;

    @Autowired
    private StatutRepository statutRepository;
    @GetMapping("/demandes")

    public List<Demande> demandes(){
        return demanderepository.findAllDemandesByDateDesc();
    }

    @PostMapping("/demandes")

    public Demande addDemande(@RequestBody Demande demande)  {
        /*
        PdfToBase64Converter pdfToBase64Converter = new PdfToBase64Converter();
        String base64String ="";
        try{
            base64String = pdfToBase64Converter.convertPdfToBase64("D:\\3SIG\\Projet_geoinfo\\demandes\\demande_construction.pdf");
        }
        catch(Exception exception){
            System.out.println(exception);
        }
       */

        demande.setDate(new Date());
        demande.setStatut(new Statut(4L,"En instance"));
        return demanderepository.save(demande);

    }

    @GetMapping("/demandes/statut/{statutId}")

    public List<Demande> getDemandesByStatut(@PathVariable Long statutId) {
        Statut statut = statutRepository.findById(statutId).orElse(null);
        return demanderepository.findDemandesByStatut(statut);
    }
    @GetMapping("/demandes/total/{statutId}")
    public ResponseEntity<Long> getCountDemandesbyStatut(@PathVariable Long statutId) {
        Statut statut = statutRepository.findById(statutId).orElse(null);
        long totalDemands = demanderepository.countByStatut(statut);
        return ResponseEntity.ok(totalDemands);
    }
    @GetMapping("/demandes/total-autorisation/{autorisationId}")
    public ResponseEntity<Long> getCountDemandesbyAutorisation(@PathVariable Long autorisationId) {
        Autorisation autorisation = autorisationRepository.findById(autorisationId).orElse(null);
        long totalDemands = demanderepository.countByAutorisation(autorisation);
        return ResponseEntity.ok(totalDemands);
    }

    @GetMapping("/demandes/total-occupation/{occupationId}")
    public ResponseEntity<Long> getCountDemandesbyOccupation(@PathVariable Long occupationId) {
        Occupation occupation = occupationRepository.findById(occupationId).orElse(null);
        long totalDemands = demanderepository.countByOccupation(occupation);
        return ResponseEntity.ok(totalDemands);
    }

    @GetMapping("/demandes/total-commune")
    public List<CommuneCount> getCountDemandesbyCommune() {
        List<CommuneCount> communeCounts = new ArrayList<>();
        List<Tuple> result = demanderepository.countDemandesByCommune();

        for (Tuple entry : result) {
            String nomCommune = (String) entry.get("nom_commune");
            Long numDemandes = (Long) entry.get("num_demandes");
            CommuneCount communeCount = new CommuneCount(nomCommune, numDemandes);
            communeCounts.add(communeCount);
        }
        return communeCounts;
    }



    @GetMapping("/demandes/total")
    public ResponseEntity<Long> getCountDemandes() {
        long totalDemands = demanderepository.count();
        return ResponseEntity.ok(totalDemands);
    }

    @GetMapping("/demandes/total-user/{userId}")
    public ResponseEntity<Long> getCountDemandesByUser(@PathVariable Long userId) {
        Utilisateur user = utilisateurRepository.findById(userId).orElse(null);
        long totalDemands = demanderepository.countByDemandeur(user);
        return ResponseEntity.ok(totalDemands);
    }
    @GetMapping("/demandes/demandes-by-user/{userId}/{statutId}")
    public ResponseEntity<Long> getCountDemandesByUserAndStatut(@PathVariable Long userId,@PathVariable Long statutId) {
        Utilisateur user = utilisateurRepository.findById(userId).orElse(null);
        Statut statut = statutRepository.findById(statutId).orElse(null);
        long totalDemands = demanderepository.countByStatutAndDemandeur(statut,user);
        return ResponseEntity.ok(totalDemands);
    }

    @GetMapping("/demandes/total-not-statut/{statutId}")
    public ResponseEntity<Long> getCountNotStatut(@PathVariable Long statutId) {
        long totalDemandsNotStatut = demanderepository.countByStatutIdNot(statutId);
        return ResponseEntity.ok(totalDemandsNotStatut);
    }



    @GetMapping("/demandes/statutnotlike/{statutId}")

    public List<Demande> getDemandesByStatutNotLike(@PathVariable Long statutId) {
        return demanderepository.findDemandesByStatutNot(statutId);
    }


    @GetMapping("/demandes/{id}")

    public Demande findDemande(@PathVariable Long id){

        return demanderepository.findById(id).orElse(null);
    }

    @PostMapping("demandes/updateStatut")
    @Transactional
    public Demande updateStatut(@RequestBody UpdateStatutRequest request) {
        Demande demande = demanderepository.findById(request.getNum_demande()).orElse(null);

        Statut statut = statutRepository.findById(request.getId_statut()).orElse(null);
        if(request.getMotif()==null){
            request.setMotif("");
        }

        if (demande != null && statut != null ) {
            demande.setMotif(request.getMotif());
            demande.setStatut(statut);
            return demanderepository.save(demande);
        } else {
            throw new RuntimeException("Demande or Statut not found");
        }
    }

    @GetMapping("/demandes_par_utilisateur/{utilisateurId}")
    public List<Demande> getDemandesByUtilisateur(@PathVariable Long utilisateurId) {
        Utilisateur user = utilisateurRepository.findById(utilisateurId).orElse(null);
        return demanderepository.findAllByDemandeur(user);
    }


}


package ma.ehtp.projet_geoinfo.web;

import lombok.Data;
import ma.ehtp.projet_geoinfo.custom.UpdateStatutRequest;
import ma.ehtp.projet_geoinfo.custom.UpdateStatutUser;
import ma.ehtp.projet_geoinfo.entities.Demande;
import ma.ehtp.projet_geoinfo.entities.Role;
import ma.ehtp.projet_geoinfo.entities.Statut;
import ma.ehtp.projet_geoinfo.entities.Utilisateur;
import ma.ehtp.projet_geoinfo.repository.DemandeRepository;
import ma.ehtp.projet_geoinfo.repository.RoleRepository;
import ma.ehtp.projet_geoinfo.repository.StatutRepository;
import ma.ehtp.projet_geoinfo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:19006", "http://localhost:3000"})
public class UtilisateurRestService {
    @Autowired
    private UtilisateurRepository utilisateurrepository;

    @Autowired
    private StatutRepository statutRepository;

    @Autowired
    private RoleRepository roleRepository;



    @GetMapping("/utilisateurs/{roleId}")

    public List<Utilisateur> getcitoyens(@PathVariable Long roleId){
        Role role = roleRepository.getRoleById(roleId);
        return utilisateurrepository.findUsersByRole(role);
    }

    @PostMapping("utilisateurs")
    @Transactional
    public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurrepository.save(utilisateur);
    }

    @GetMapping("/utilisateurs")

    public List<Utilisateur> getUtilisateurs(){
        return utilisateurrepository.findAll();
    }



    @PostMapping("utilisateurs/updateStatut")
    @Transactional
    public Utilisateur updateStatut(@RequestBody UpdateStatutUser request) {
       Utilisateur utilisateur = utilisateurrepository.findById(request.getId_user()).orElse(null);

        Statut statut = statutRepository.findById(request.getId_statut()).orElse(null);
        if(request.getMotif()==null){
            request.setMotif("");
        }

        if (utilisateur != null && statut != null ) {
            utilisateur.setMotif(request.getMotif());
            utilisateur.setStatut(statut);
            return utilisateurrepository.save(utilisateur);
        } else {
            throw new RuntimeException("User or Statut not found");
        }
    }

    }




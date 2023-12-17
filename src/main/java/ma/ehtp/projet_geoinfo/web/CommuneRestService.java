package ma.ehtp.projet_geoinfo.web;

import ma.ehtp.projet_geoinfo.entities.Commune;
import ma.ehtp.projet_geoinfo.repository.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = {"http://localhost:19006", "http://localhost:3000"})
public class CommuneRestService {
    @Autowired
    private CommuneRepository communerepository;

    @GetMapping("/communes")

    public List<Commune> communes(){

        return communerepository.findAll();
    }


    @GetMapping("/communes/{id}")

    public Commune findCommune(@PathVariable Long id){

        return communerepository.findById(id).orElse(null);
    }

    @GetMapping("/communes/{longitude}/{latitude}")
    public Long getIdCommuneByDemande(@PathVariable("longitude") double longitude, @PathVariable("latitude") double latitude) {
        return communerepository.getIdCommuneByDemande(longitude, latitude);
    }
}

package ma.ehtp.projet_geoinfo.repository;

import ma.ehtp.projet_geoinfo.entities.Demande;
import ma.ehtp.projet_geoinfo.entities.Role;
import ma.ehtp.projet_geoinfo.entities.Statut;
import ma.ehtp.projet_geoinfo.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findByEmailAndPassword(String email, String password);

    List<Utilisateur> findUsersByRole(Role role);




}

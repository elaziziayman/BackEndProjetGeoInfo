package ma.ehtp.projet_geoinfo.repository;

import jakarta.persistence.Tuple;
import ma.ehtp.projet_geoinfo.custom.CommuneCount;
import ma.ehtp.projet_geoinfo.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DemandeRepository  extends JpaRepository<Demande,Long> {
    @Query("SELECT d FROM Demande d WHERE d.demandeur = :demandeur ORDER BY d.date DESC")

    List<Demande> findAllByDemandeur(@Param("demandeur") Utilisateur demandeur);
    List<Demande> findDemandesByStatut(Statut statut);
    @Query("SELECT d FROM Demande d WHERE d.statut.id <> :statutId")
    List<Demande> findDemandesByStatutNot(@Param("statutId") Long statutId);
    @Query("SELECT d FROM Demande d ORDER BY d.date DESC")
    List<Demande> findAllDemandesByDateDesc();

    long count();
    long countByStatut(Statut statut);
    long countByStatutIdNot(@Param("statutId") Long statutId);

    long countByAutorisation(Autorisation autorisation);

    long countByDemandeur(Utilisateur demandeur);
    long countByStatutAndDemandeur(Statut statut, Utilisateur demandeur);
    long countByOccupation(Occupation occupation);

    @Query(value = "SELECT communes.nom AS nom_commune, COUNT(demandes.num_demande) AS num_demandes " +
            "FROM demandes " +
            "INNER JOIN communes ON demandes.id_commune = communes.id " +
            "GROUP BY communes.nom", nativeQuery = true)
    List<Tuple> countDemandesByCommune();





}

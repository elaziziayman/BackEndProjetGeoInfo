package ma.ehtp.projet_geoinfo.repository;

import ma.ehtp.projet_geoinfo.entities.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutRepository extends JpaRepository<Statut,Long> {
    Statut getStatutById(Long id);
}

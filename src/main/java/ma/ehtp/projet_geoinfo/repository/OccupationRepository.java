package ma.ehtp.projet_geoinfo.repository;

import ma.ehtp.projet_geoinfo.entities.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupationRepository extends JpaRepository<Occupation,Long> {
}

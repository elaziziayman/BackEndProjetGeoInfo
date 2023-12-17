package ma.ehtp.projet_geoinfo.repository;

import ma.ehtp.projet_geoinfo.entities.Commune;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CommuneRepository extends JpaRepository<Commune,Long> {
    @Query(value = "SELECT id FROM communes WHERE ST_Intersects(geom, ST_SetSRID(ST_MakePoint(:longitude, :latitude), 4326))", nativeQuery = true)
    Long getIdCommuneByDemande(@Param("longitude") double longitude, @Param("latitude") double latitude);

}

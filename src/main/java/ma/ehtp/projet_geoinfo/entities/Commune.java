package ma.ehtp.projet_geoinfo.entities;


import jakarta.persistence.*;
import org.locationtech.jts.geom.MultiPolygon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "communes")
@Data @AllArgsConstructor @NoArgsConstructor
public class Commune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private MultiPolygon geom;

    private String nom;
    private Double surface;

}

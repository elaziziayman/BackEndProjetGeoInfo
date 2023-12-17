package ma.ehtp.projet_geoinfo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Statut")
@Data @AllArgsConstructor @NoArgsConstructor
public class Statut {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

}

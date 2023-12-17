package ma.ehtp.projet_geoinfo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Autorisation")
@Data @AllArgsConstructor @NoArgsConstructor
public class Autorisation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
}

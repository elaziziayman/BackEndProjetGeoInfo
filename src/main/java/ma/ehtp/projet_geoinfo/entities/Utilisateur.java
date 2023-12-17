package ma.ehtp.projet_geoinfo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "Utilisateurs")
@Data @AllArgsConstructor @NoArgsConstructor
public class Utilisateur {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String cin;
    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "id_statut", referencedColumnName = "id")
    private Statut statut;
    private String motif;


}



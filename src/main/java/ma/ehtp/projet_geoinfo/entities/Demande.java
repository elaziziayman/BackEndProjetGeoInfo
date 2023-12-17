package ma.ehtp.projet_geoinfo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "Demandes")
@Data @AllArgsConstructor @NoArgsConstructor
public class Demande  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num_demande;
    @ManyToOne
    @JoinColumn(name = "id_demandeur", referencedColumnName = "id")
    private Utilisateur demandeur;
    private Float x,y;
    @ManyToOne
    @JoinColumn(name = "id_autorisation", referencedColumnName = "id")
    private Autorisation autorisation;
    @ManyToOne
    @JoinColumn(name = "id_occupation", referencedColumnName = "id")
    private Occupation occupation;
    private Date date;
    @Column(columnDefinition = "TEXT")
    private String piece_jointe_1;
    @Column(columnDefinition = "TEXT")
    private String piece_jointe_2;
    @Column(columnDefinition = "TEXT")
    private String piece_jointe_3;
    @ManyToOne
    @JoinColumn(name = "id_statut", referencedColumnName = "id")
    private Statut statut;
    private String motif;
    @ManyToOne
    @JoinColumn(name = "id_commune", referencedColumnName = "id")
    private Commune commune;



}

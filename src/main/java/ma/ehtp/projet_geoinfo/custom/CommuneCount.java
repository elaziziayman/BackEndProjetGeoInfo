package ma.ehtp.projet_geoinfo.custom;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CommuneCount {
    private String nom_commune;
    private Long num_demandes;

}

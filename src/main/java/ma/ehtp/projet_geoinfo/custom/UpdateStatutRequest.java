package ma.ehtp.projet_geoinfo.custom;

import lombok.Data;

@Data
public class UpdateStatutRequest {
    private Long num_demande;
    private Long id_statut;
    private String motif;


}

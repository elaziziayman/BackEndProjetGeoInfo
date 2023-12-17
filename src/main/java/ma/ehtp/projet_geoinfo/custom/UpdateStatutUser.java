package ma.ehtp.projet_geoinfo.custom;

import lombok.Data;

@Data

public class UpdateStatutUser {
    private Long id_user;
    private Long id_statut;
    private String motif;
}

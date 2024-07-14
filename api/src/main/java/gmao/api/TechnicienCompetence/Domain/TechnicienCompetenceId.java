package gmao.api.TechnicienCompetence.Domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class TechnicienCompetenceId implements Serializable {
    private Long idTechnicien;
    private Long idCompetence;

    public TechnicienCompetenceId() {}

    public TechnicienCompetenceId(Long idTechnicien, Long idCompetence) {
        this.idTechnicien = idTechnicien;
        this.idCompetence = idCompetence;
    }
}
package gmao.api.TechnicienCompetence.Domain;

import gmao.api.Competence.Domain.Competence;
import gmao.api.Utilisateur.Domain.Utilisateur;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TechnicienCompetence {
    @EmbeddedId
    private TechnicienCompetenceId id;

    @ManyToOne
    @MapsId("idTechnicien")
    @JoinColumn(name = "id_technicien")
    private Utilisateur technicien;

    @ManyToOne
    @MapsId("idCompetence")
    @JoinColumn(name = "id_competence")
    private Competence competence;
}



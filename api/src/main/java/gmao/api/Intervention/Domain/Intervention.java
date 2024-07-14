package gmao.api.Intervention.Domain;

import gmao.api.Equipement.Domain.Equipement;
import gmao.api.TypeIntervention.Domain.TypeIntervention;
import gmao.api.Utilisateur.Domain.Utilisateur;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateIntervention;
    private String statut;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_equipement")
    private Equipement equipement;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_type_intervention")
    private TypeIntervention typeIntervention;
}


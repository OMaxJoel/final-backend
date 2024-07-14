package gmao.api.Maintenance.Domain;

import gmao.api.Equipement.Domain.Equipement;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String frequence;
    private String description;
    private Date dateDebut;
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "id_equipement")
    private Equipement equipement;
}

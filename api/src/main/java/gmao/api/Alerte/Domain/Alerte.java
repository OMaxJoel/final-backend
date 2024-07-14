package gmao.api.Alerte.Domain;

import gmao.api.Equipement.Domain.Equipement;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Alerte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateAlerte;
    private String type;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_equipement")
    private Equipement equipement;
}


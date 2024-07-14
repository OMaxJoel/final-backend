package gmao.api.Contrat.Domain;

import gmao.api.Equipement.Domain.Equipement;
import gmao.api.Fournisseur.Domain.Fournisseur;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomFournisseur;
    private Date dateDebut;
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "id_equipement")
    private Equipement equipement;

    @ManyToOne
    @JoinColumn(name = "id_fournisseur")
    private Fournisseur fournisseur;
}


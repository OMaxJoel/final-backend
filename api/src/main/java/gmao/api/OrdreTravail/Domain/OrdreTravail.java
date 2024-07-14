package gmao.api.OrdreTravail.Domain;

import gmao.api.Equipement.Domain.Equipement;
import gmao.api.Utilisateur.Domain.Utilisateur;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "Ordre_Travail")
public class OrdreTravail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateOrdre;
    private String description;
    private String priorite;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "id_equipement")
    private Equipement equipement;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;
}

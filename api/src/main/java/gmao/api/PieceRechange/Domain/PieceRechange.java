package gmao.api.PieceRechange.Domain;

import gmao.api.Equipement.Domain.Equipement;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PieceRechange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private int quantite;
    private String emplacement;

    @ManyToOne
    @JoinColumn(name = "id_equipement")
    private Equipement equipement;
}


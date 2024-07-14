package gmao.api.Fournisseur.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    private String telephone;
}

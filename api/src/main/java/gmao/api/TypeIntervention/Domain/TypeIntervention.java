package gmao.api.TypeIntervention.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TypeIntervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
}

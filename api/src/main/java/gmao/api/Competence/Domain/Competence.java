package gmao.api.Competence.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
}

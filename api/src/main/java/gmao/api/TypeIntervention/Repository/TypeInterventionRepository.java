package gmao.api.TypeIntervention.Repository;

import gmao.api.TypeIntervention.Domain.TypeIntervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeInterventionRepository extends JpaRepository<TypeIntervention, Long> {
}

package gmao.api.TechnicienCompetence.Repository;

import gmao.api.TechnicienCompetence.Domain.TechnicienCompetence;
import gmao.api.TechnicienCompetence.Domain.TechnicienCompetenceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicienCompetenceRepository extends JpaRepository<TechnicienCompetence, TechnicienCompetenceId> {
}


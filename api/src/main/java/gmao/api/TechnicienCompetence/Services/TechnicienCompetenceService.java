package gmao.api.TechnicienCompetence.Services;

import gmao.api.TechnicienCompetence.Domain.TechnicienCompetence;
import gmao.api.TechnicienCompetence.Domain.TechnicienCompetenceId;
import gmao.api.TechnicienCompetence.Repository.TechnicienCompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TechnicienCompetenceService {
    @Autowired
    private TechnicienCompetenceRepository technicienCompetenceRepository;

    public List<TechnicienCompetence> findAll() {
        return technicienCompetenceRepository.findAll();
    }

    public Optional<TechnicienCompetence> findById(TechnicienCompetenceId id) {
        return technicienCompetenceRepository.findById(id);
    }

    public TechnicienCompetence save(TechnicienCompetence technicienCompetence) {
        return technicienCompetenceRepository.save(technicienCompetence);
    }

    public void deleteById(TechnicienCompetenceId id) {
        technicienCompetenceRepository.deleteById(id);
    }
}


package gmao.api.Competence.Services;

import gmao.api.Competence.Domain.Competence;
import gmao.api.Competence.Repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompetenceService {
    @Autowired
    private CompetenceRepository competenceRepository;

    public List<Competence> findAll() {
        return competenceRepository.findAll();
    }

    public Optional<Competence> findById(Long id) {
        return competenceRepository.findById(id);
    }

    public Competence save(Competence competence) {
        return competenceRepository.save(competence);
    }

    public void deleteById(Long id) {
        competenceRepository.deleteById(id);
    }
}


package gmao.api.Intervention.Services;

import gmao.api.Intervention.Domain.Intervention;
import gmao.api.Intervention.Repository.InterventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InterventionService {
    @Autowired
    private InterventionRepository interventionRepository;

    public List<Intervention> findAll() {
        return interventionRepository.findAll();
    }

    public Optional<Intervention> findById(Long id) {
        return interventionRepository.findById(id);
    }

    public Intervention save(Intervention intervention) {
        return interventionRepository.save(intervention);
    }

    public void deleteById(Long id) {
        interventionRepository.deleteById(id);
    }
}

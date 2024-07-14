package gmao.api.TypeIntervention.Services;

import gmao.api.TypeIntervention.Domain.TypeIntervention;
import gmao.api.TypeIntervention.Repository.TypeInterventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TypeInterventionService {
    @Autowired
    private TypeInterventionRepository typeInterventionRepository;

    public List<TypeIntervention> findAll() {
        return typeInterventionRepository.findAll();
    }

    public Optional<TypeIntervention> findById(Long id) {
        return typeInterventionRepository.findById(id);
    }

    public TypeIntervention save(TypeIntervention typeIntervention) {
        return typeInterventionRepository.save(typeIntervention);
    }

    public void deleteById(Long id) {
        typeInterventionRepository.deleteById(id);
    }
}


package gmao.api.Alerte.Services;

import gmao.api.Alerte.Domain.Alerte;
import gmao.api.Alerte.Repository.AlerteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlerteService {
    @Autowired
    private AlerteRepository alerteRepository;

    public List<Alerte> findAll() {
        return alerteRepository.findAll();
    }

    public Optional<Alerte> findById(Long id) {
        return alerteRepository.findById(id);
    }

    public Alerte save(Alerte alerte) {
        return alerteRepository.save(alerte);
    }

    public void deleteById(Long id) {
        alerteRepository.deleteById(id);
    }
}


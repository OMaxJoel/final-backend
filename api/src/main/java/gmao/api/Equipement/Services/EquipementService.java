package gmao.api.Equipement.Services;

import gmao.api.Equipement.Domain.Equipement;
import gmao.api.Equipement.Repository.EquipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EquipementService {
    @Autowired
    private EquipementRepository equipementRepository;

    public List<Equipement> findAll() {
        return equipementRepository.findAll();
    }

    public Optional<Equipement> findById(Long id) {
        return equipementRepository.findById(id);
    }

    public Equipement save(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    public void deleteById(Long id) {
        equipementRepository.deleteById(id);
    }
}


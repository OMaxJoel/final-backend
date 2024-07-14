package gmao.api.Equipement.Controller;

import gmao.api.Equipement.Domain.Equipement;
import gmao.api.Equipement.Services.EquipementService;

import gmao.api.Equipement.config.KafkaConsumer;
import gmao.api.Equipement.config.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/equipements")
public class EquipementController {
    @Autowired
    private EquipementService equipementService;

    @Autowired
    private KafkaProducer kafkaProducer;

    private final KafkaConsumer kafkaConsumer;

    @Autowired
    public EquipementController(KafkaConsumer kafkaConsumer) {
        this.kafkaConsumer = kafkaConsumer;
    }

    @GetMapping("/consumed")
    public List<Equipement> getConsumedMessages() {
        return kafkaConsumer.getMessages();
    }

    @GetMapping
    public List<Equipement> getAllEquipements() {
        return equipementService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Long id) {
        return equipementService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Equipement createEquipement(@RequestBody Equipement equipement) {
        Equipement savedEquipement = equipementService.save(equipement);
        kafkaProducer.sendMessage(savedEquipement);
        return savedEquipement;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipement> updateEquipement(@PathVariable Long id, @RequestBody Equipement equipementDetails) {
        return equipementService.findById(id)
                .map(equipement -> {
                    equipement.setNom(equipementDetails.getNom());
                    equipement.setDescription(equipementDetails.getDescription());
                    equipement.setDateAcquisition(equipementDetails.getDateAcquisition());
                    equipement.setStatut(equipementDetails.getStatut());
                    equipement.setEmplacement(equipementDetails.getEmplacement());
                    return ResponseEntity.ok(equipementService.save(equipement));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Long id) {
        if (equipementService.findById(id).isPresent()) {
            equipementService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


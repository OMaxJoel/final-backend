package gmao.api.Alerte.Controller;

import gmao.api.Alerte.Domain.Alerte;
import gmao.api.Alerte.Services.AlerteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alettes")
public class AlerteController {
    @Autowired
    private AlerteService alerteService;

    @GetMapping
    public List<Alerte> getAllAlertes() {
        return alerteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerte> getAlerteById(@PathVariable Long id) {
        return alerteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Alerte createAlerte(@RequestBody Alerte alerte) {
        return alerteService.save(alerte);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alerte> updateAlerte(@PathVariable Long id, @RequestBody Alerte alerteDetails) {
        return alerteService.findById(id)
                .map(alerte -> {
                    alerte.setDateAlerte(alerteDetails.getDateAlerte());
                    alerte.setDescription(alerteDetails.getDescription());
                    alerte.setEquipement(alerteDetails.getEquipement());
                    return ResponseEntity.ok(alerteService.save(alerte));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlerte(@PathVariable Long id) {
        if (alerteService.findById(id).isPresent()) {
            alerteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


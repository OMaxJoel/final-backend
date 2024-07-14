package gmao.api.Intervention.Controller;

import gmao.api.Intervention.Domain.Intervention;
import gmao.api.Intervention.Services.InterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interventions")
public class InterventionController {
    @Autowired
    private InterventionService interventionService;

    @GetMapping
    public List<Intervention> getAllInterventions() {
        return interventionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Intervention> getInterventionById(@PathVariable Long id) {
        return interventionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Intervention createIntervention(@RequestBody Intervention intervention) {
        return interventionService.save(intervention);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Intervention> updateIntervention(@PathVariable Long id, @RequestBody Intervention interventionDetails) {
        return interventionService.findById(id)
                .map(intervention -> {
                    intervention.setDateIntervention(interventionDetails.getDateIntervention());
                    intervention.setDescription(interventionDetails.getDescription());
                    intervention.setEquipement(interventionDetails.getEquipement());
                    intervention.setUtilisateur(interventionDetails.getUtilisateur());
                    intervention.setTypeIntervention(interventionDetails.getTypeIntervention());
                    return ResponseEntity.ok(interventionService.save(intervention));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIntervention(@PathVariable Long id) {
        if (interventionService.findById(id).isPresent()) {
            interventionService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


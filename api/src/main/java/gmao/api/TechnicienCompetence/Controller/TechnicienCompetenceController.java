package gmao.api.TechnicienCompetence.Controller;

import gmao.api.TechnicienCompetence.Domain.TechnicienCompetence;
import gmao.api.TechnicienCompetence.Domain.TechnicienCompetenceId;
import gmao.api.TechnicienCompetence.Services.TechnicienCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/techniciens-competences")
public class TechnicienCompetenceController {
    @Autowired
    private TechnicienCompetenceService technicienCompetenceService;

    @GetMapping
    public List<TechnicienCompetence> getAllTechniciensCompetences() {
        return technicienCompetenceService.findAll();
    }

    @GetMapping("/{technicienId}/{competenceId}")
    public ResponseEntity<TechnicienCompetence> getTechnicienCompetenceById(@PathVariable Long technicienId, @PathVariable Long competenceId) {
        TechnicienCompetenceId id = new TechnicienCompetenceId(technicienId, competenceId);
        return technicienCompetenceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TechnicienCompetence createTechnicienCompetence(@RequestBody TechnicienCompetence technicienCompetence) {
        return technicienCompetenceService.save(technicienCompetence);
    }

    @DeleteMapping("/{technicienId}/{competenceId}")
    public ResponseEntity<Void> deleteTechnicienCompetence(@PathVariable Long technicienId, @PathVariable Long competenceId) {
        TechnicienCompetenceId id = new TechnicienCompetenceId(technicienId, competenceId);
        if (technicienCompetenceService.findById(id).isPresent()) {
            technicienCompetenceService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


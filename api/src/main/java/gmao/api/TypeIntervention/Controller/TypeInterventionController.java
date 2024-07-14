package gmao.api.TypeIntervention.Controller;

import gmao.api.TypeIntervention.Domain.TypeIntervention;
import gmao.api.TypeIntervention.Services.TypeInterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types-intervention")
public class TypeInterventionController {
    @Autowired
    private TypeInterventionService typeInterventionService;

    @GetMapping
    public List<TypeIntervention> getAllTypesIntervention() {
        return typeInterventionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeIntervention> getTypeInterventionById(@PathVariable Long id) {
        return typeInterventionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TypeIntervention createTypeIntervention(@RequestBody TypeIntervention typeIntervention) {
        return typeInterventionService.save(typeIntervention);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeIntervention> updateTypeIntervention(@PathVariable Long id, @RequestBody TypeIntervention typeInterventionDetails) {
        return typeInterventionService.findById(id)
                .map(typeIntervention -> {
                    typeIntervention.setNom(typeInterventionDetails.getNom());
                    typeIntervention.setDescription(typeInterventionDetails.getDescription());
                    return ResponseEntity.ok(typeInterventionService.save(typeIntervention));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeIntervention(@PathVariable Long id) {
        if (typeInterventionService.findById(id).isPresent()) {
            typeInterventionService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

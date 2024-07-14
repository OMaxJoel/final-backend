package gmao.api.OrdreTravail.Controller;

import gmao.api.OrdreTravail.Domain.OrdreTravail;
import gmao.api.OrdreTravail.Services.OrdreTravailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordres-travail")
public class OrdreTravailController {
    @Autowired
    private OrdreTravailService ordreTravailService;

    @GetMapping
    public List<OrdreTravail> getAllOrdresTravail() {
        return ordreTravailService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdreTravail> getOrdreTravailById(@PathVariable Long id) {
        return ordreTravailService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrdreTravail createOrdreTravail(@RequestBody OrdreTravail ordreTravail) {
        return ordreTravailService.save(ordreTravail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdreTravail> updateOrdreTravail(@PathVariable Long id, @RequestBody OrdreTravail ordreTravailDetails) {
        return ordreTravailService.findById(id)
                .map(ordreTravail -> {
                    ordreTravail.setDateOrdre(ordreTravailDetails.getDateOrdre());
                    ordreTravail.setDescription(ordreTravailDetails.getDescription());
                    ordreTravail.setPriorite(ordreTravailDetails.getPriorite());
                    ordreTravail.setStatut(ordreTravailDetails.getStatut());
                    ordreTravail.setEquipement(ordreTravailDetails.getEquipement());
                    ordreTravail.setUtilisateur(ordreTravailDetails.getUtilisateur());
                    return ResponseEntity.ok(ordreTravailService.save(ordreTravail));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrdreTravail(@PathVariable Long id) {
        if (ordreTravailService.findById(id).isPresent()) {
            ordreTravailService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


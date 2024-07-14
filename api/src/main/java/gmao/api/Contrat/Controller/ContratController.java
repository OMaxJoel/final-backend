package gmao.api.Contrat.Controller;

import gmao.api.Contrat.Domain.Contrat;
import gmao.api.Contrat.Services.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {
    @Autowired
    private ContratService contratService;

    @GetMapping
    public List<Contrat> getAllContrats() {
        return contratService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> getContratById(@PathVariable Long id) {
        return contratService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contrat createContrat(@RequestBody Contrat contrat) {
        return contratService.save(contrat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrat> updateContrat(@PathVariable Long id, @RequestBody Contrat contratDetails) {
        return contratService.findById(id)
                .map(contrat -> {
                    contrat.setDateDebut(contratDetails.getDateDebut());
                    contrat.setDateFin(contratDetails.getDateFin());
                    contrat.setEquipement(contratDetails.getEquipement());
                    contrat.setFournisseur(contratDetails.getFournisseur());
                    return ResponseEntity.ok(contratService.save(contrat));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrat(@PathVariable Long id) {
        if (contratService.findById(id).isPresent()) {
            contratService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


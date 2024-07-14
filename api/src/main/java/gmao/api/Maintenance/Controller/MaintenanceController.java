package gmao.api.Maintenance.Controller;

import gmao.api.Maintenance.Domain.Maintenance;
import gmao.api.Maintenance.Services.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController {
    @Autowired
    private MaintenanceService maintenanceService;

    @GetMapping
    public List<Maintenance> getAllMaintenances() {
        return maintenanceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> getMaintenanceById(@PathVariable Long id) {
        return maintenanceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Maintenance createMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.save(maintenance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> updateMaintenance(@PathVariable Long id, @RequestBody Maintenance maintenanceDetails) {
        return maintenanceService.findById(id)
                .map(maintenance -> {
                    maintenance.setDateDebut(maintenanceDetails.getDateDebut());
                    maintenance.setDateFin(maintenanceDetails.getDateFin());
                    maintenance.setDescription(maintenanceDetails.getDescription());
                    maintenance.setEquipement(maintenanceDetails.getEquipement());
                    return ResponseEntity.ok(maintenanceService.save(maintenance));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaintenance(@PathVariable Long id) {
        if (maintenanceService.findById(id).isPresent()) {
            maintenanceService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


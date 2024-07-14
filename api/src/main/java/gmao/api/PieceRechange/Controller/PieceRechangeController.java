package gmao.api.PieceRechange.Controller;

import gmao.api.PieceRechange.Domain.PieceRechange;
import gmao.api.PieceRechange.Services.PieceRechangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pieces-rechange")
public class PieceRechangeController {
    @Autowired
    private PieceRechangeService pieceRechangeService;

    @GetMapping
    public List<PieceRechange> getAllPiecesRechange() {
        return pieceRechangeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PieceRechange> getPieceRechangeById(@PathVariable Long id) {
        return pieceRechangeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PieceRechange createPieceRechange(@RequestBody PieceRechange pieceRechange) {
        return pieceRechangeService.save(pieceRechange);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PieceRechange> updatePieceRechange(@PathVariable Long id, @RequestBody PieceRechange pieceRechangeDetails) {
        return pieceRechangeService.findById(id)
                .map(pieceRechange -> {
                    pieceRechange.setNom(pieceRechangeDetails.getNom());
                    pieceRechange.setQuantite(pieceRechangeDetails.getQuantite());
                    pieceRechange.setEmplacement(pieceRechangeDetails.getEmplacement());
                    pieceRechange.setEquipement(pieceRechangeDetails.getEquipement());
                    return ResponseEntity.ok(pieceRechangeService.save(pieceRechange));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePieceRechange(@PathVariable Long id) {
        if (pieceRechangeService.findById(id).isPresent()) {
            pieceRechangeService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


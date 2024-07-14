package gmao.api.PieceRechange.Services;

import gmao.api.PieceRechange.Domain.PieceRechange;
import gmao.api.PieceRechange.Repository.PieceRechangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PieceRechangeService {
    @Autowired
    private PieceRechangeRepository pieceRechangeRepository;

    public List<PieceRechange> findAll() {
        return pieceRechangeRepository.findAll();
    }

    public Optional<PieceRechange> findById(Long id) {
        return pieceRechangeRepository.findById(id);
    }

    public PieceRechange save(PieceRechange pieceRechange) {
        return pieceRechangeRepository.save(pieceRechange);
    }

    public void deleteById(Long id) {
        pieceRechangeRepository.deleteById(id);
    }
}


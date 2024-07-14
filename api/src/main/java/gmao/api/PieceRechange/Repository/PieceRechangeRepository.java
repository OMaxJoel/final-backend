package gmao.api.PieceRechange.Repository;

import gmao.api.PieceRechange.Domain.PieceRechange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceRechangeRepository extends JpaRepository<PieceRechange, Long> {
}

package gmao.api.OrdreTravail.Repository;

import gmao.api.OrdreTravail.Domain.OrdreTravail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdreTravailRepository extends JpaRepository<OrdreTravail, Long> {
}

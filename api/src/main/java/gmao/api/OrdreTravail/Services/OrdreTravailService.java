package gmao.api.OrdreTravail.Services;

import gmao.api.OrdreTravail.Domain.OrdreTravail;
import gmao.api.OrdreTravail.Repository.OrdreTravailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrdreTravailService {
    @Autowired
    private OrdreTravailRepository ordreTravailRepository;

    public List<OrdreTravail> findAll() {
        return ordreTravailRepository.findAll();
    }

    public Optional<OrdreTravail> findById(Long id) {
        return ordreTravailRepository.findById(id);
    }

    public OrdreTravail save(OrdreTravail ordreTravail) {
        return ordreTravailRepository.save(ordreTravail);
    }

    public void deleteById(Long id) {
        ordreTravailRepository.deleteById(id);
    }
}


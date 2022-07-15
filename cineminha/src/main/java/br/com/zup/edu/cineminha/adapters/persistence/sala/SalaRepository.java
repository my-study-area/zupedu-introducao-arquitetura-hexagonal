package br.com.zup.edu.cineminha.adapters.persistence.sala;

import br.com.zup.edu.cineminha.domain.sala.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> {
}

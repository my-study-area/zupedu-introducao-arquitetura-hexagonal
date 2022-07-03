package br.com.zup.edu.pharmacia.adapters;

import br.com.zup.edu.pharmacia.domain.remedio.Remedio;
import org.springframework.data.repository.CrudRepository;

public interface RemedioRepository extends CrudRepository<Remedio, Long> {
}

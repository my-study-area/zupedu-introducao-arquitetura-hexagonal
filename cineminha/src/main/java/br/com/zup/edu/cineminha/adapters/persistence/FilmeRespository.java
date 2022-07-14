package br.com.zup.edu.cineminha.adapters.persistence;

import br.com.zup.edu.cineminha.domain.Filme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRespository extends CrudRepository<Filme, Long> {
}

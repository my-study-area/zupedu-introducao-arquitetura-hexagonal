package br.com.zup.edu.cineminha.adapters.persistence.filme;

import br.com.zup.edu.cineminha.domain.filme.Filme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRespository extends CrudRepository<Filme, Long> {
}

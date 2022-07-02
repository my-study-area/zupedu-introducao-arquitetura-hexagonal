package br.com.zup.edu.pharmacia.adapters;

import br.com.zup.edu.pharmacia.domain.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}

package br.com.zup.edu.pharmacia.adapters.categoria;

import br.com.zup.edu.pharmacia.domain.categoria.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}

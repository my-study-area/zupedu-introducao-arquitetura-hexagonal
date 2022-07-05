package br.com.zup.edu.pharmacia.domain.categoria;

import java.util.Optional;

public interface CategoriaRepositoryOutputPort {
    Categoria cadastrar(Categoria categoria);

    Optional<Categoria> buscarPorId(Long categoriaId);
}

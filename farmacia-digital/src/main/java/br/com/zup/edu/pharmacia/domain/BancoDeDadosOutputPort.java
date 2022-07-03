package br.com.zup.edu.pharmacia.domain;

import java.util.Optional;

public interface BancoDeDadosOutputPort {
    void cadastrar(Categoria categoria);

    Optional<Categoria> buscarPorId(Long categoriaId);
}

package br.com.zup.edu.pharmacia.domain;

import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private final CategoriaRepositoryOutputPort repository;

    public CategoriaService(CategoriaRepositoryOutputPort repository) {
        this.repository = repository;
    }

    public void cadastrar (Categoria categoria) {
        repository.cadastrar(categoria);
    }

    public Categoria buscarPorId(Long categoriaId) throws Exception {
        return repository.buscarPorId(categoriaId).orElseThrow(
            () -> {
                return new Exception("Não foi possível");
            }
        );
    }
}

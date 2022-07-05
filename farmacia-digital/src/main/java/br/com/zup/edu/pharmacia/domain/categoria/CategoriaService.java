package br.com.zup.edu.pharmacia.domain.categoria;

import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private final CategoriaRepositoryOutputPort repository;

    public CategoriaService(CategoriaRepositoryOutputPort repository) {
        this.repository = repository;
    }

    public Categoria cadastrar (CategoriaRequestInputPort categoriaRequest) {
        Categoria categoria = categoriaRequest.toModel();
        return repository.cadastrar(categoria);
    }

    public Categoria buscarPorId(Long categoriaId) throws Exception {
        return repository.buscarPorId(categoriaId)
                .orElseThrow(() -> new Exception("Não foi possível encontrar a categoria"));
    }
}

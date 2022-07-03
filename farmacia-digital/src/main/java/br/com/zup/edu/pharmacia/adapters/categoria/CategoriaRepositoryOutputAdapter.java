package br.com.zup.edu.pharmacia.adapters.categoria;

import br.com.zup.edu.pharmacia.domain.categoria.CategoriaRepositoryOutputPort;
import br.com.zup.edu.pharmacia.domain.categoria.Categoria;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoriaRepositoryOutputAdapter implements CategoriaRepositoryOutputPort {
    private final CategoriaRepository repository;

    public CategoriaRepositoryOutputAdapter(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrar(Categoria categoria) {
        repository.save(categoria);
    }

    @Override
    public Optional<Categoria> buscarPorId(Long categoriaId) {
        return repository.findById(categoriaId);
    }
}

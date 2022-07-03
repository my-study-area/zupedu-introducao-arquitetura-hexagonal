package br.com.zup.edu.pharmacia.adapters;

import br.com.zup.edu.pharmacia.domain.BancoDeDadosOutputPort;
import br.com.zup.edu.pharmacia.domain.Categoria;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class H2OutputAdapter implements BancoDeDadosOutputPort {
    private final CategoriaRepository repository;

    public H2OutputAdapter(CategoriaRepository repository) {
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

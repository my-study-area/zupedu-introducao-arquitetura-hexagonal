package br.com.zup.edu.pharmacia.domain;

import br.com.zup.edu.pharmacia.adapters.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public void cadastrar (Categoria categoria) {
        repository.save(categoria);
    }

    public Categoria buscarPorId(Long categoriaId) throws Exception {
        return repository.findById(categoriaId).orElseThrow(
            () -> {
                return new Exception("Não foi possível");
            }
        );
    }
}

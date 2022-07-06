package br.com.zup.edu.pharmacia.domain.remedio;

import br.com.zup.edu.pharmacia.domain.categoria.Categoria;
import org.springframework.stereotype.Service;

@Service
public class RemedioService {
    private final RemedioRepositoryOutputPort repository;

    public RemedioService(RemedioRepositoryOutputPort repository) {
        this.repository = repository;
    }

    public Remedio cadastrar(RemedioRequestInputPort remedioRequest, Categoria categoria) {
        Remedio remedio = remedioRequest.toModel(categoria);
        repository.cadastrar(remedio);
        return remedio;
    }
}

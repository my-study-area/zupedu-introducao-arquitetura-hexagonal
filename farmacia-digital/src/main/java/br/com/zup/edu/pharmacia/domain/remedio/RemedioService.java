package br.com.zup.edu.pharmacia.domain.remedio;

import org.springframework.stereotype.Service;

@Service
public class RemedioService {
    private final RemedioRepositoryOutputPort repository;

    public RemedioService(RemedioRepositoryOutputPort repository) {
        this.repository = repository;
    }

    public void cadastrar(Remedio remedio) {
        repository.cadastrar(remedio);
    }
}

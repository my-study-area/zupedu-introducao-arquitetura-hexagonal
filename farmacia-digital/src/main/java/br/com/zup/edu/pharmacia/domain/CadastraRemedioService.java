package br.com.zup.edu.pharmacia.domain;

import org.springframework.stereotype.Service;

@Service
public class CadastraRemedioService {
    private final RemedioRepositoryOutputPort repository;

    public CadastraRemedioService(RemedioRepositoryOutputPort repository) {
        this.repository = repository;
    }

    public void cadastrar(Remedio remedio) {
        repository.cadastrar(remedio); ;
    }
}

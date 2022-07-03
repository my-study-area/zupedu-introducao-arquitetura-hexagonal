package br.com.zup.edu.pharmacia.domain;

import br.com.zup.edu.pharmacia.adapters.RemedioRepository;
import org.springframework.stereotype.Service;

@Service
public class RemedioService {
    private final RemedioRepository repository;

    public RemedioService(RemedioRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Remedio remedio) {
        repository.save(remedio) ;
    }
}

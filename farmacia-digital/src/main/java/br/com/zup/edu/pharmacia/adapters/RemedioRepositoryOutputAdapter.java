package br.com.zup.edu.pharmacia.adapters;

import br.com.zup.edu.pharmacia.domain.Remedio;
import br.com.zup.edu.pharmacia.domain.RemedioRepositoryOutputPort;
import org.springframework.stereotype.Component;

@Component
public class RemedioRepositoryOutputAdapter implements RemedioRepositoryOutputPort {
    private final RemedioRepository repository;

    public RemedioRepositoryOutputAdapter(RemedioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrar(Remedio remedio) {
        repository.save(remedio);
    }
}

package br.com.zup.edu.pharmacia.adapters;

import br.com.zup.edu.pharmacia.domain.Remedio;
import br.com.zup.edu.pharmacia.domain.RemedioRepositoryOutputPort;
import org.springframework.stereotype.Component;

@Component
public class CadastrarRemedioRepository implements RemedioRepositoryOutputPort {
    private final RemedioRepository repository;

    public CadastrarRemedioRepository(RemedioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrar(Remedio remedio) {
        repository.save(remedio);
    }
}

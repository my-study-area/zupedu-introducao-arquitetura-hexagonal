package br.com.zup.edu.cineminha.adapters.persistence;

import br.com.zup.edu.cineminha.domain.CadastraNovaSalaRepository;
import br.com.zup.edu.cineminha.domain.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SqlSalaAdapter implements CadastraNovaSalaRepository {

    @Autowired
    private SalaRepository repository;

    @Override
    public Sala salva(Sala sala) {
        return repository.save(sala);
    }

}

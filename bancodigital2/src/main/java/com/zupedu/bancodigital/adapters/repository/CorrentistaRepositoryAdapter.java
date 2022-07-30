package com.zupedu.bancodigital.adapters.repository;

import com.zupedu.bancodigital.domain.correntista.Correntista;
import com.zupedu.bancodigital.domain.correntista.CorrentistaRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CorrentistaRepositoryAdapter implements CorrentistaRepositoryPort {
    private final CorrentistaRepository repository;

    public CorrentistaRepositoryAdapter(CorrentistaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Correntista cadastrar(Correntista correntista) {
        return repository.save(correntista);
    }

    @Override
    public Optional<Correntista> buscarPorId(Long correntistaId) {
        return repository.findById(correntistaId);
    }
}

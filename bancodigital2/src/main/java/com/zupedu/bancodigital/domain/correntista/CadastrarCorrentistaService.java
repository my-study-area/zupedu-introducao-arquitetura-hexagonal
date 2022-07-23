package com.zupedu.bancodigital.domain.correntista;

import org.springframework.stereotype.Service;

@Service
public class CadastrarCorrentistaService {
    private final CorrentistaRepositoryPort repository;

    public CadastrarCorrentistaService(CorrentistaRepositoryPort repository) {
        this.repository = repository;
    }

    public Correntista cadastrar(Correntista correntista ) {
        return repository.cadastrar(correntista);
    }
}

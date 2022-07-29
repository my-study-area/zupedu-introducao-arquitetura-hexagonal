package com.zupedu.bancodigital.domain.conta;

import org.springframework.stereotype.Service;

@Service
public class CadastraNovaContaService {

    private final ContaRepositoryPort repository;

    public CadastraNovaContaService(
            ContaRepositoryPort repository) {
        this.repository = repository;
    }

    public Conta cadastrar(Conta conta) {
        return repository.cadastrar(conta);
    }
}

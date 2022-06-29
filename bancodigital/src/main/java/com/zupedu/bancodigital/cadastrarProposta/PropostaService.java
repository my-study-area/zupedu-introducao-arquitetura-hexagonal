package com.zupedu.bancodigital.cadastrarProposta;

import org.springframework.stereotype.Service;

@Service
public class PropostaService {
    private final BancoDeDadosRepositoryPort repository;

    public PropostaService(BancoDeDadosRepositoryPort repository) {
        this.repository = repository;
    }

    public void cadastrar(Proposta proposta) {
        repository.cadastrar(proposta);
    }
}

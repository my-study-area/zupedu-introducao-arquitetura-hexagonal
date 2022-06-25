package com.zupedu.bancodigital.cadastrarProposta;

import org.springframework.stereotype.Component;

@Component
public class PostgresRepositoryAdapter implements BancoDeDadosRepositoryPort<Proposta> {
    private PropostaRepository repository;

    public PostgresRepositoryAdapter(PropostaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrar(Proposta proposta) {
        repository.save(proposta);
    }
}

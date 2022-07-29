package com.zupedu.bancodigital.adapters.repository;

import com.zupedu.bancodigital.domain.conta.Conta;
import com.zupedu.bancodigital.domain.conta.ContaRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class ContaRepositoryPortAdapter implements ContaRepositoryPort {
    private final ContaRepository repository;

    public ContaRepositoryPortAdapter(ContaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Conta cadastrar(Conta conta) {
        return repository.save(conta);
    }
}

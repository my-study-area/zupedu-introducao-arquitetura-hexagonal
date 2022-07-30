package com.zupedu.bancodigital.domain.correntista;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarCorrentistaService {

    private final CorrentistaRepositoryPort repository;

    public BuscarCorrentistaService(
            CorrentistaRepositoryPort repository) {
        this.repository = repository;
    }

    public Optional<Correntista> buscarPorId(Long correntistaId) {
        return repository.buscarPorId(correntistaId);
    }
}

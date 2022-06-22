package com.zupedu.bancodigital.domain;

import org.springframework.stereotype.Service;

@Service
public class CriaNovoAutorService {

    private final CadastraAutorRepository repository;

    public CriaNovoAutorService(CadastraAutorRepository repository) {
        this.repository = repository;
    }

    public Autor cria(DadosNovoAutor request) {
        var autor = request.toModel();
        return repository.salva(autor);
    }
}

package br.com.zup.edu.cineminha.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastraNovaSala {

    @Autowired
    private CadastraNovaSalaRepository repository;

    public Sala criaNovaSalaPelo(String nome) {

        return repository.salva(new Sala(nome));
    }

}

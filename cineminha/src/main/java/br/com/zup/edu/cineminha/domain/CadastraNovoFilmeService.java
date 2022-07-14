package br.com.zup.edu.cineminha.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastraNovoFilmeService {
    @Autowired
    private CadastraNovoFilmeRepository repository;

    public Filme cadastrar(Filme filme) {
        return repository.cadastrar(filme);
    }
}

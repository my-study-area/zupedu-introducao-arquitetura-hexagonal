package br.com.zup.edu.cineminha.domain;

import org.springframework.stereotype.Repository;

public interface CadastraNovoFilmeRepository {
    Filme cadastrar(Filme filme);
}

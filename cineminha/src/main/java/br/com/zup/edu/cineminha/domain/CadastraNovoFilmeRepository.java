package br.com.zup.edu.cineminha.domain;

import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CadastraNovoFilmeRepository {
    Filme cadastrar(Filme filme);

    Optional<Filme> buscarPorId(long filmeId);
}

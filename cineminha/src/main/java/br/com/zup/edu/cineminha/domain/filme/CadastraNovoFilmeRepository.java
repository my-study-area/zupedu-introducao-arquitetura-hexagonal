package br.com.zup.edu.cineminha.domain.filme;

import br.com.zup.edu.cineminha.domain.filme.Filme;

import java.util.Optional;

public interface CadastraNovoFilmeRepository {
    Filme cadastrar(Filme filme);

    Optional<Filme> buscarPorId(long filmeId);
}

package br.com.zup.edu.cineminha.domain.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManterFilmeService {
    @Autowired
    private CadastraNovoFilmeRepository repository;

    public Filme cadastrar(Filme filme) {
        return repository.cadastrar(filme);
    }

    public Optional<Filme> buscarPorId(long filmeId) {
        return repository.buscarPorId(filmeId);
    }
}

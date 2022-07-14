package br.com.zup.edu.cineminha.adapters.persistence;

import br.com.zup.edu.cineminha.domain.CadastraNovoFilmeRepository;
import br.com.zup.edu.cineminha.domain.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SqlFilmeAdapter implements CadastraNovoFilmeRepository {
    @Autowired
    private FilmeRespository respository;

    @Override
    public Filme cadastrar(Filme filme) {
        return respository.save(filme);
    }
}

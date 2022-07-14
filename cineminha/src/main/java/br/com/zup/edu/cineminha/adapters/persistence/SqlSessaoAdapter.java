package br.com.zup.edu.cineminha.adapters.persistence;

import br.com.zup.edu.cineminha.domain.CadastraNovaSessaoRepository;
import br.com.zup.edu.cineminha.domain.Sessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SqlSessaoAdapter implements CadastraNovaSessaoRepository {
    @Autowired
    private SessaoRepository repository;

    @Override
    public Sessao cadastrar(Sessao sessao) {
        return repository.save(sessao);
    }
}

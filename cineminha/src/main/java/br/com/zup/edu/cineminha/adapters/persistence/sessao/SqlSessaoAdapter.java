package br.com.zup.edu.cineminha.adapters.persistence.sessao;

import br.com.zup.edu.cineminha.domain.sessao.CadastraNovaSessaoRepository;
import br.com.zup.edu.cineminha.domain.sessao.Sessao;
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

package br.com.zup.edu.cineminha.domain.sessao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastraNovaSessaoService {
    @Autowired
    private CadastraNovaSessaoRepository repository;

    public Sessao cadastrar(Sessao sessao) {
        return repository.cadastrar(sessao);
    }
}

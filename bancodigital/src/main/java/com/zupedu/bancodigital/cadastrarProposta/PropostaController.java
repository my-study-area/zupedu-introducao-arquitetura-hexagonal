package com.zupedu.bancodigital.cadastrarProposta;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/propostas")
public class PropostaController {
    private BancoDeDadosRepositoryPort repository;

    public PropostaController(BancoDeDadosRepositoryPort repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(NovaPropostaRequest novaPropostaRequest, UriComponentsBuilder uriBuilder) {
        var proposta = novaPropostaRequest.toModel();
        repository.cadastrar(proposta);
        var uri = uriBuilder.path("/propostas/{id}").buildAndExpand(proposta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

package br.com.zup.edu.cineminha.application;

import br.com.zup.edu.cineminha.domain.CadastraNovaSessaoService;
import br.com.zup.edu.cineminha.domain.CadastraNovoFilmeService;
import br.com.zup.edu.cineminha.domain.Sessao;
import br.com.zup.edu.cineminha.adapters.persistence.sala.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/sessoes")
public class SessaoController {

    @Autowired
    private CadastraNovaSessaoService sessaoService;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private CadastraNovoFilmeService filmeService;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovaSessaoRequest request,
                                      UriComponentsBuilder uriBuilder) {

        Sessao sessao = request.toModel(salaRepository, filmeService);
        this.sessaoService.cadastrar(sessao);

        var location = uriBuilder.path("/api/sessoes/{id}")
                .buildAndExpand(sessao.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


}

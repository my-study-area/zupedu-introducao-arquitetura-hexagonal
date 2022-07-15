package br.com.zup.edu.cineminha.application.filme;

import br.com.zup.edu.cineminha.domain.filme.CadastraNovoFilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController {

    @Autowired
    private CadastraNovoFilmeService service;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovoFilmeRequest request,
                                      UriComponentsBuilder uriBuilder) {

        var filme = service.cadastrar(request.toModel());

        var location = uriBuilder.path("/api/filmes/{id}")
                .buildAndExpand(filme.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


}

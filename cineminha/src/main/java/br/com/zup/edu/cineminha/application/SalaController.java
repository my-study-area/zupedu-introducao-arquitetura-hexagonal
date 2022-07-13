package br.com.zup.edu.cineminha.application;

import br.com.zup.edu.cineminha.domain.CadastraNovaSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    @Autowired
    private CadastraNovaSala service;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovaSalaRequest request,
                                      UriComponentsBuilder uriBuilder) {

        var sala = service.criaNovaSalaPelo(request.getNome());

        var location = uriBuilder.path("/api/salas/{id}")
                .buildAndExpand(sala.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}

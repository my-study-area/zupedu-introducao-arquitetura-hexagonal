package com.zupedu.bancodigital.application;

import com.zupedu.bancodigital.domain.CriaNovoAutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class NovoAutorController {

    private final CriaNovoAutorService service;

    public NovoAutorController(CriaNovoAutorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoAutorRequest request,
                                       UriComponentsBuilder uriBuilder) {
        var autor = service.cria(request);
        URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

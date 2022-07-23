package com.zupedu.bancodigital.application.correntista;

import com.zupedu.bancodigital.application.input.NovoCorrentistaRequest;
import com.zupedu.bancodigital.domain.correntista.CadastrarCorrentistaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/correntista")
public class CorrentistaController {

    private final CadastrarCorrentistaService service;

    public CorrentistaController(CadastrarCorrentistaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovoCorrentistaRequest request,
                                      UriComponentsBuilder uriBuilder) {


        var correntista = service.cadastrar(request.paraCorrentista());

        var location = uriBuilder.path("/api/correntista/{id}")
                .buildAndExpand(correntista.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

}

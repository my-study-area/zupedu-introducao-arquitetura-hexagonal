package com.zupedu.bancodigital.application.conta;

import com.zupedu.bancodigital.application.input.NovaContaRequest;
import com.zupedu.bancodigital.domain.conta.CadastraNovaContaService;
import com.zupedu.bancodigital.domain.correntista.BuscarCorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private CadastraNovaContaService contaService;

    @Autowired
    private BuscarCorrentistaService buscarCorrentistaService;

    @PostMapping
    public ResponseEntity<?> cadastra(@Valid @RequestBody NovaContaRequest request,
                                      UriComponentsBuilder uriBuilder) {


        var conta = request.paraConta(buscarCorrentistaService);
        this.contaService.cadastrar(conta);

        var location = uriBuilder.path("/api/contas/{id}")
                .buildAndExpand(conta.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}

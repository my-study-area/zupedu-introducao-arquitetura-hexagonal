package br.com.zup.edu.pharmacia.application;

import br.com.zup.edu.pharmacia.adapters.CategoriaRequestAdapter;
import br.com.zup.edu.pharmacia.domain.BancoDeDadosOutputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private BancoDeDadosOutputPort repository;

    public CategoriaController(BancoDeDadosOutputPort repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody CategoriaRequestAdapter request, UriComponentsBuilder uriBuilder) {
        var categoria = request.toModel();
        repository.cadastrar(categoria);
        var uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
//        var uri = uriBuilder.path("/categorias/{id}").buildAndExpand("1zzz").toUri();
        return ResponseEntity.created(uri).build();
    }

}

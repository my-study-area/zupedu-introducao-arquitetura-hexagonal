package br.com.zup.edu.pharmacia.application;

import br.com.zup.edu.pharmacia.adapters.categoria.CategoriaRequestInputAdapter;
import br.com.zup.edu.pharmacia.domain.categoria.Categoria;
import br.com.zup.edu.pharmacia.domain.categoria.CategoriaService;
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

    private CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody CategoriaRequestInputAdapter request, UriComponentsBuilder uriBuilder) {
        Categoria categoria = service.cadastrar(request);
        var uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}

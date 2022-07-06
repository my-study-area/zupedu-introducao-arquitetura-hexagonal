package br.com.zup.edu.pharmacia.application;

import br.com.zup.edu.pharmacia.adapters.remedio.RemedioRequestInputAdapter;
import br.com.zup.edu.pharmacia.domain.categoria.Categoria;
import br.com.zup.edu.pharmacia.domain.categoria.CategoriaService;
import br.com.zup.edu.pharmacia.domain.remedio.Remedio;
import br.com.zup.edu.pharmacia.domain.remedio.RemedioRepositoryOutputPort;
import br.com.zup.edu.pharmacia.domain.remedio.RemedioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/remedios")
public class RemedioController {
    private final RemedioService remedioService;
    private final CategoriaService categoriaService;

    public RemedioController(RemedioService remedioService, CategoriaService categoriaService) {
        this.remedioService = remedioService;
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid RemedioRequestInputAdapter request,
                                       UriComponentsBuilder uriBuilder) throws Exception {
        Categoria categoria = categoriaService.buscarPorId(request.getCategoriaId());
        Remedio remedio = remedioService.cadastrar(request, categoria);
        URI uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

package br.com.zup.edu.pharmacia.application;

import br.com.zup.edu.pharmacia.adapters.RemedioRequest;
import br.com.zup.edu.pharmacia.domain.*;
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
    private final RemedioRepositoryOutputPort remedioRepository;
    private final CategoriaService categoriaService;

    public RemedioController(RemedioRepositoryOutputPort remedioRepository, CategoriaService categoriaService) {
        this.remedioRepository = remedioRepository;
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid RemedioRequest request,
                                       UriComponentsBuilder uriBuilder) throws Exception {
        Categoria categoria = categoriaService.buscarPorId(request.getCategoriaId());
        Remedio remedio = request.toModel(categoria);
        remedioRepository.cadastrar(remedio);
        URI uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

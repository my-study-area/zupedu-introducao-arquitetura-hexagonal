package br.com.zup.edu.exemplohexagonal.application;

import br.com.zup.edu.exemplohexagonal.domain.Desconto;
import br.com.zup.edu.exemplohexagonal.domain.ports.TaxaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/desconto")
public class DescontoController {
    private final TaxaRepository repository;

    public DescontoController(TaxaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> calcularDesconto(@Valid @RequestBody CalculaDescontoRequest request) {
        var desconto = new Desconto(repository);
        desconto.calcular(request.getValor());
        return ResponseEntity.ok().build();
    }
    
}

package br.com.estudo.custodia.mock;

import br.com.estudo.custodia.LiquidacaoRequestDTO;
import br.com.estudo.custodia.LiquidacaoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CustodiaController {

    @GetMapping("/v1/baixar")
    public ResponseEntity<Object> baixar() {
        return ResponseEntity.ok(Map.of("status", "200"));
    }

    @PostMapping("/v1/baixar")
    public ResponseEntity<LiquidacaoResponseDTO> baixar2(@RequestBody LiquidacaoRequestDTO request) {
        LiquidacaoResponseDTO response = new LiquidacaoResponseDTO(200, request.numeroContrato());
        return ResponseEntity.ok(response);
    }
}

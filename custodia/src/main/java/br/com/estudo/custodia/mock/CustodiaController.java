package br.com.estudo.custodia.mock;

import br.com.estudo.custodia.adapter.out.dto.LiquidacaoRequestDTO;
import br.com.estudo.custodia.adapter.out.dto.LiquidacaoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustodiaController {

    @PostMapping("/v1/baixar")
    public ResponseEntity<LiquidacaoResponseDTO> baixar(@RequestBody LiquidacaoRequestDTO request) {
        LiquidacaoResponseDTO response = new LiquidacaoResponseDTO(request.numeroContrato());
        return ResponseEntity.ok(response);
    }
}

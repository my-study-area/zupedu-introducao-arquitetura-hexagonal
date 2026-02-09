package br.com.estudo.custodia.adapter.out;

import br.com.estudo.custodia.adapter.out.dto.LiquidacaoRequestDTO;
import br.com.estudo.custodia.adapter.out.dto.LiquidacaoResponseDTO;
import br.com.estudo.custodia.core.domain.RespostaHttp;
import br.com.estudo.custodia.port.out.LiquidarHttpClientPort;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestClient;

public class LiquidarRestClientAdapter implements LiquidarHttpClientPort {
    private RestClient client;
    private String  uri;

    public LiquidarRestClientAdapter(String baseUrl, String uri) {
        this.client = RestClient.builder().baseUrl(baseUrl).build();
        this.uri = uri;
    }

    @Override
    public RespostaHttp post(Object body) {
        LiquidacaoRequestDTO request = (LiquidacaoRequestDTO) body;
        ResponseEntity<LiquidacaoResponseDTO> responseEntity = client.post()
                .uri(uri)
                .body(request)
                .retrieve()
                .toEntity(LiquidacaoResponseDTO.class);
        Assert.notNull(responseEntity, "Não deve ser nulo");
        int statusCode = responseEntity.getStatusCode().value();
        return new RespostaHttp(statusCode, responseEntity.getBody());
    }
}

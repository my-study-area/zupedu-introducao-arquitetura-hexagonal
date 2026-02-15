package br.com.estudo.custodia.adapter.out;

import br.com.estudo.custodia.adapter.dto.api.LiquidacaoRequestDTO;
import br.com.estudo.custodia.adapter.dto.api.LiquidacaoResponseDTO;
import br.com.estudo.custodia.adapter.dto.api.RespostaHttp;
import br.com.estudo.custodia.port.out.LiquidarHttpClientPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestClient;

public class LiquidarRestClientAdapter implements LiquidarHttpClientPort {
    private static final Logger logger = LoggerFactory.getLogger(LiquidarRestClientAdapter.class);
    private RestClient client;
    private String  uri;

    public LiquidarRestClientAdapter(String baseUrl, String uri) {
        this.client = RestClient.builder().baseUrl(baseUrl).build();
        this.uri = uri;
    }

    @Override
    public RespostaHttp post(Object body) {
        logger.info("Iniciando a requisição HTTP para liquidação");
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

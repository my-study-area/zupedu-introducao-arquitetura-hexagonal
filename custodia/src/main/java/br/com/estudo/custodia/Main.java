package br.com.estudo.custodia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);

        // Evento
        Parcela parcela1 = new Parcela(1, LocalDate.now(), new BigDecimal(5));
        Parcela parcela2 = new Parcela(2, LocalDate.now(), new BigDecimal(5));
        List<Parcela> parcelas = List.of(parcela1, parcela2);
        EventoLiquidacao eventoLiquidacao = new EventoLiquidacao("0123", parcelas, BigDecimal.TEN, 0);
        Header header = new Header(UUID.randomUUID().toString(), "topico1");
        Evento<EventoLiquidacao> evento = new Evento<>(header, eventoLiquidacao);
        logger.info("Evento: {}", evento.getData());

        // Request API liquidação
        LiquidacaoRequestDTO requestDTO = LiquidacaoMapper.toRequestDTO(evento.getData());
        RestClient client = RestClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
        String resposta = client.post()
                .uri("/v1/baixar")
                .body(requestDTO)
                .retrieve()
                .body(String.class);
        logger.info("Resposta: {}", resposta);

        // Envio de resposta de mensageria
        EventoRetorno eventoRetorno = new EventoRetorno(ResponseEntity.ok(resposta), eventoLiquidacao);
        ProducerKafka producerKafka = new ProducerKafka(eventoRetorno);
        producerKafka.send();


    }
}

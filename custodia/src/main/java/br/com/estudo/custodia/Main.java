package br.com.estudo.custodia;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoLiquidacao;
import br.com.estudo.custodia.adapter.dto.mensageria.EventoParcela;
import br.com.estudo.custodia.adapter.dto.mensageria.Header;
import br.com.estudo.custodia.adapter.dto.mensageria.Liquidacao;
import br.com.estudo.custodia.adapter.in.ConsumerKafkaAdapter;
import br.com.estudo.custodia.adapter.mapper.LiquidacaoMapper;
import br.com.estudo.custodia.adapter.out.LiquidarRestClientAdapter;
import br.com.estudo.custodia.adapter.out.ProducerPortKafkaAdapter;
import br.com.estudo.custodia.core.domain.LiquidacaoService;
import br.com.estudo.custodia.port.out.BrokerProducerPort;
import br.com.estudo.custodia.port.out.LiquidarHttpClientPort;
import br.com.estudo.custodia.usecase.LiquidacaoUseCase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Evento
        EventoParcela eventoParcela1 = new EventoParcela(1, LocalDate.now(), new BigDecimal(5));
        EventoParcela eventoParcela2 = new EventoParcela(2, LocalDate.now(), new BigDecimal(5));
        List<EventoParcela> eventoParcelas = List.of(eventoParcela1, eventoParcela2);
        Liquidacao liquidacao = new Liquidacao("0123", eventoParcelas, BigDecimal.TEN, 0);
        Header header = new Header(UUID.randomUUID().toString(), "topico1");
        EventoLiquidacao evento = new EventoLiquidacao(header, liquidacao);

        // dependências
        LiquidacaoMapper liquidacaoMapper = new LiquidacaoMapper();
        LiquidarHttpClientPort clientPort = new LiquidarRestClientAdapter("http://localhost:8080", "/v1/baixar");
        BrokerProducerPort broker = new ProducerPortKafkaAdapter();
        LiquidacaoService service = new LiquidacaoUseCase(liquidacaoMapper, clientPort, broker);
        ConsumerKafkaAdapter consumer = new ConsumerKafkaAdapter(service);

        // consumer
        consumer.consumir(evento);
    }
}

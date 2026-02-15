package br.com.estudo.custodia;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoLiquidacaoCPR;
import br.com.estudo.custodia.adapter.dto.mensageria.EventoLiquidacaoNCE;
import br.com.estudo.custodia.adapter.dto.mensageria.EventoParcela;
import br.com.estudo.custodia.adapter.dto.mensageria.Header;
import br.com.estudo.custodia.adapter.in.ConsumerKafkaAdapter;
import br.com.estudo.custodia.adapter.mapper.CprMapper;
import br.com.estudo.custodia.adapter.mapper.LiquidacaoMapper;
import br.com.estudo.custodia.adapter.mapper.LiquidacaoMapperFactory;
import br.com.estudo.custodia.adapter.mapper.MapperLiquidacaoDinamico;
import br.com.estudo.custodia.adapter.mapper.NceMapper;
import br.com.estudo.custodia.adapter.out.LiquidarRestClientAdapter;
import br.com.estudo.custodia.adapter.out.ProduceRetornoRetornoKafkaAdapter;
import br.com.estudo.custodia.adapter.out.ProduceSaidaKafkaAdapter;
import br.com.estudo.custodia.core.domain.LiquidacaoCPR;
import br.com.estudo.custodia.core.domain.LiquidacaoModernizadoService;
import br.com.estudo.custodia.core.domain.LiquidacaoNCE;
import br.com.estudo.custodia.core.domain.LiquidacaoService;
import br.com.estudo.custodia.port.out.BrokerProduceRetornoPort;
import br.com.estudo.custodia.port.out.BrokerProduceSaidaPort;
import br.com.estudo.custodia.port.out.BuscaContratoModernizado;
import br.com.estudo.custodia.port.out.BuscaContratoModernizadoMemoriaAdapter;
import br.com.estudo.custodia.port.out.BuscaContratoModernizadoRepository;
import br.com.estudo.custodia.port.out.LiquidarHttpClientPort;
import br.com.estudo.custodia.usecase.LiquidacaoModernizadoUseCase;
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
        LiquidacaoCPR liquidacaoCPR = new LiquidacaoCPR("0123", eventoParcelas, BigDecimal.TEN, 0);
        LiquidacaoNCE liquidacaoNCE = new LiquidacaoNCE("0123", eventoParcelas, BigDecimal.TEN, 0);
        Header header = new Header(UUID.randomUUID().toString(), "topico1");
        EventoLiquidacaoCPR eventoCPR = new EventoLiquidacaoCPR(header, liquidacaoCPR);
        EventoLiquidacaoNCE eventoLiquidacaoNCE = new EventoLiquidacaoNCE(header, liquidacaoNCE);

        // Dependências Compartilhada
        MapperLiquidacaoDinamico liquidacaoCPRMapper = new CprMapper();
        MapperLiquidacaoDinamico liquidacaoNCEMapper = new NceMapper();
        List<MapperLiquidacaoDinamico> liquidacoesMapper = List.of(liquidacaoCPRMapper, liquidacaoNCEMapper);
        LiquidacaoMapperFactory liquidacaoMapperFactory = new LiquidacaoMapperFactory(liquidacoesMapper);

        // Dependências Legado
        LiquidarHttpClientPort clientPort = new LiquidarRestClientAdapter("http://localhost:8080", "/v1/baixar");
        BrokerProduceRetornoPort brokerRetorno = new ProduceRetornoRetornoKafkaAdapter();
        LiquidacaoMapper liquidacaoMapper = new LiquidacaoMapper();
        LiquidacaoService serviceLiquidacaoLegado = new LiquidacaoUseCase(liquidacaoMapper, clientPort, brokerRetorno);

        // Dependências Modernizado
        BuscaContratoModernizadoRepository repository = new BuscaContratoModernizadoRepository();
        BuscaContratoModernizado buscaContratoModernizado = new BuscaContratoModernizadoMemoriaAdapter(repository);
        BrokerProduceSaidaPort brokerSaida = new ProduceSaidaKafkaAdapter();
        LiquidacaoModernizadoService serviceLiquidacaoModernizado = new LiquidacaoModernizadoUseCase(buscaContratoModernizado, brokerSaida);

        // consumer
        ConsumerKafkaAdapter consumer = new ConsumerKafkaAdapter(serviceLiquidacaoLegado, serviceLiquidacaoModernizado,liquidacaoMapperFactory);
        consumer.consumir(eventoCPR);
        consumer.consumir(eventoLiquidacaoNCE);
    }
}

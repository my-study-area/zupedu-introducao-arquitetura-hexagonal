package br.com.estudo.custodia.adapter.in;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoBase;
import br.com.estudo.custodia.adapter.mapper.LiquidacaoMapper;
import br.com.estudo.custodia.adapter.mapper.LiquidacaoMapperFactory;
import br.com.estudo.custodia.core.domain.Liquidacao;
import br.com.estudo.custodia.core.domain.LiquidacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerKafkaAdapter {
    private final Logger logger = LoggerFactory.getLogger(ConsumerKafkaAdapter.class);
    private final LiquidacaoService liquidacaoUseCase;
    private final LiquidacaoMapperFactory liquidacaoMapperFactory;

    public ConsumerKafkaAdapter(LiquidacaoService liquidacaoUseCase, LiquidacaoMapperFactory liquidacaoMapperFactory) {
        this.liquidacaoUseCase = liquidacaoUseCase;
        this.liquidacaoMapperFactory = liquidacaoMapperFactory;
    }

    public void consumir(EventoBase evento) {
        try {
            logger.info("Consumindo evento: {}", evento);
            LiquidacaoMapper mapper = liquidacaoMapperFactory.build(evento);
            Liquidacao liquidacao = mapper.toModel(evento.getData());
            liquidacaoUseCase.liquidar(liquidacao);
        } catch (Exception e) {
            logger.error("Erro ao consumir evento: {}", e.getMessage());
        }
    }

}

package br.com.estudo.custodia.adapter.in;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoBase;
import br.com.estudo.custodia.adapter.mapper.LiquidacaoCPRMapper;
import br.com.estudo.custodia.core.domain.Liquidacao;
import br.com.estudo.custodia.core.domain.LiquidacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerKafkaAdapter {
    private final Logger logger = LoggerFactory.getLogger(ConsumerKafkaAdapter.class);

    private final LiquidacaoService liquidacaoUseCase;
    private final LiquidacaoCPRMapper liquidacaoCPRMapper;

    public ConsumerKafkaAdapter(LiquidacaoService liquidacaoUseCase, LiquidacaoCPRMapper liquidacaoCPRMapper) {
        this.liquidacaoUseCase = liquidacaoUseCase;
        this.liquidacaoCPRMapper = liquidacaoCPRMapper;
    }

    public void consumir(EventoBase evento) {
        try {
            logger.info("Consumindo evento: {}", evento);
            Liquidacao liquidacao = liquidacaoCPRMapper.toModel(evento.getData());
            liquidacaoUseCase.liquidar(liquidacao);
        } catch (Exception e) {
            logger.error("Erro ao consumir evento: {}", e.getMessage());
        }
    }
}

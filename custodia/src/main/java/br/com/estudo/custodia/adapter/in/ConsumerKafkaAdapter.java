package br.com.estudo.custodia.adapter.in;

import br.com.estudo.custodia.adapter.mapper.LiquidacaoMapper;
import br.com.estudo.custodia.adapter.dto.mensageria.EventoBase;
import br.com.estudo.custodia.core.domain.Liquidacao;
import br.com.estudo.custodia.core.domain.LiquidacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ConsumerKafkaAdapter {
    private final Logger logger = LoggerFactory.getLogger(ConsumerKafkaAdapter.class);

    private final LiquidacaoService liquidacaoUseCase;
    private final List<LiquidacaoMapper<?>> liquidacoesMapper;

    public ConsumerKafkaAdapter(LiquidacaoService liquidacaoUseCase, List<LiquidacaoMapper<?>> liquidacoesMapper) {
        this.liquidacaoUseCase = liquidacaoUseCase;
        this.liquidacoesMapper = liquidacoesMapper;
    }

    public void consumir(EventoBase evento) {
        try {
            logger.info("Consumindo evento: {}", evento);
            Liquidacao liquidacao = getLiquidacao(evento);
            liquidacaoUseCase.liquidar(liquidacao);
        } catch (Exception e) {
            logger.error("Erro ao consumir evento: {}", e.getMessage());
        }
    }

    private Liquidacao getLiquidacao(EventoBase evento) {
        LiquidacaoMapper mapperLiquidacao = liquidacoesMapper.stream()
                .filter(mapper -> mapper.isValid(evento))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Mapper de liquidação não encontrado"));

        return mapperLiquidacao.toModel(evento.getData());
    }
}

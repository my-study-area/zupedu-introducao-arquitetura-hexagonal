package br.com.estudo.custodia.usecase;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoEntradaSistemaModerno;
import br.com.estudo.custodia.core.domain.Liquidacao;
import br.com.estudo.custodia.core.domain.LiquidacaoModernizadoService;
import br.com.estudo.custodia.port.out.BrokerProduceSaidaPort;
import br.com.estudo.custodia.port.out.BuscaContratoModernizado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LiquidacaoModernizadoUseCase implements LiquidacaoModernizadoService {
    private static final Logger logger = LoggerFactory.getLogger(LiquidacaoModernizadoUseCase.class);
    public static final String SIGLA_SISTEMA_ORIGEM_OPERACAO = "ABC";
    private final BuscaContratoModernizado buscaContrato;
    private final BrokerProduceSaidaPort broker;

    public LiquidacaoModernizadoUseCase(BuscaContratoModernizado buscaContrato, BrokerProduceSaidaPort broker) {
        this.buscaContrato = buscaContrato;
        this.broker = broker;
    }

    @Override
    public void liquidar(Liquidacao liquidacao) {
        logger.info("Iniciando o fluxo de liquidação modernizado");
        String numeroContratoModernizado = buscaContrato.findById(liquidacao.getNumeroContrato(), SIGLA_SISTEMA_ORIGEM_OPERACAO)
                .orElseThrow(() -> new RuntimeException("Numero de contrato modernizado não encontrado"))
                .getNumeroContratoModernizado();
        EventoEntradaSistemaModerno evento = new EventoEntradaSistemaModerno(liquidacao, numeroContratoModernizado);
        broker.send(evento);
    }
}

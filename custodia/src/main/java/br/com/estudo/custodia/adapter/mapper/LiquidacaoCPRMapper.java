package br.com.estudo.custodia.adapter.mapper;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoBase;
import br.com.estudo.custodia.core.domain.Liquidacao;
import br.com.estudo.custodia.core.domain.LiquidacaoCPR;

public class LiquidacaoCPRMapper extends LiquidacaoMapper {
    @Override
    public Liquidacao toModel(Object liquidacao) {
        LiquidacaoCPR liquidacaoCPR = (LiquidacaoCPR) liquidacao;
        return new Liquidacao(
                liquidacaoCPR.getNumeroContratoLegado(),
                liquidacaoCPR.getFluxoEventoParcelas(),
                liquidacaoCPR.getValorTotal(),
                liquidacaoCPR.getMotivoBaixa());
    }

    @Override
    public boolean isValid(EventoBase eventoBase) {
        return eventoBase.getData() instanceof LiquidacaoCPR;
    }
}

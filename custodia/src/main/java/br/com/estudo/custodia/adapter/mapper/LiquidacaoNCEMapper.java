package br.com.estudo.custodia.adapter.mapper;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoBase;
import br.com.estudo.custodia.core.domain.Liquidacao;
import br.com.estudo.custodia.core.domain.LiquidacaoNCE;

public class LiquidacaoNCEMapper extends LiquidacaoMapper<LiquidacaoNCE> {
    @Override
    public Liquidacao toModel(LiquidacaoNCE liquidacao) {
        return new Liquidacao(
                liquidacao.getNumeroOperacaoBoleto(),
                liquidacao.getFluxoEventoParcelas(),
                liquidacao.getValorTotal(),
                liquidacao.getMotivoBaixa());
    }

    @Override
    public boolean isValid(EventoBase eventoBase) {
        return eventoBase.getData() instanceof LiquidacaoNCE;
    }
}

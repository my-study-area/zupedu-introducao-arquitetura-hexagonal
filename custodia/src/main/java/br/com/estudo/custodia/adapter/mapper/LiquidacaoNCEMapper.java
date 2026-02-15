package br.com.estudo.custodia.adapter.mapper;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoBase;
import br.com.estudo.custodia.core.domain.Liquidacao;
import br.com.estudo.custodia.core.domain.LiquidacaoNCE;

public class LiquidacaoNCEMapper extends LiquidacaoMapper {
    @Override
    public Liquidacao toModel(Object liquidacao) {
        LiquidacaoNCE liquidacaoNCE = (LiquidacaoNCE) liquidacao;
        return new Liquidacao(
                liquidacaoNCE.getNumeroOperacaoBoleto(),
                liquidacaoNCE.getFluxoEventoParcelas(),
                liquidacaoNCE.getValorTotal(),
                liquidacaoNCE.getMotivoBaixa());
    }

    @Override
    public boolean isValid(EventoBase eventoBase) {
        return eventoBase.getData() instanceof LiquidacaoNCE;
    }
}

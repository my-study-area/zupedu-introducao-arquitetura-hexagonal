package br.com.estudo.custodia;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LiquidacaoMapper {

    public static LiquidacaoRequestDTO toRequestDTO(EventoLiquidacao evento) {
        if (evento == null) return null;

        List<ParcelaRequestDTO> parcelasDTO = evento.getFluxoParcelas().stream()
                .map(LiquidacaoMapper::toParcelaDTO)
                .toList();

        return new LiquidacaoRequestDTO(
                evento.getNumeroContrato(),
                parcelasDTO,
                evento.getValorTotal(),
                evento.getMotivoBaixa()
        );
    }

    public static ParcelaRequestDTO toParcelaDTO(Parcela parcela) {
        if (parcela == null) return null;

        return new ParcelaRequestDTO(
                parcela.getNumeroParcela(),
                parcela.getDataVencimento(),
                parcela.getValor()
        );
    }

}

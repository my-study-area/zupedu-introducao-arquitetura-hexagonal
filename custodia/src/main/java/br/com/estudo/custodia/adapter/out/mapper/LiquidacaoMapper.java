package br.com.estudo.custodia.adapter.out.mapper;

import br.com.estudo.custodia.ParcelaRequestDTO;
import br.com.estudo.custodia.adapter.out.dto.LiquidacaoRequestDTO;
import br.com.estudo.custodia.core.domain.Liquidacao;
import br.com.estudo.custodia.core.domain.Parcela;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LiquidacaoMapper {

    public static LiquidacaoRequestDTO toRequestDTO(Liquidacao evento) {
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

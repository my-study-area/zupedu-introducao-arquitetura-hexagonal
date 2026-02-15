package br.com.estudo.custodia.adapter.mapper;

import br.com.estudo.custodia.adapter.dto.api.LiquidacaoRequestDTO;
import br.com.estudo.custodia.adapter.dto.api.ParcelaRequestDTO;
import br.com.estudo.custodia.adapter.dto.mensageria.EventoParcela;
import br.com.estudo.custodia.core.domain.Liquidacao;

import java.util.List;

public class LiquidacaoRequestDTOMapper {
    public LiquidacaoRequestDTO toDTO(Liquidacao evento) {
        if (evento == null) return null;

        List<ParcelaRequestDTO> parcelasDTO = evento.getFluxoParcelas().stream()
                .map(this::toParcelaDTO)
                .toList();

        return new LiquidacaoRequestDTO(
                evento.getNumeroContrato(),
                parcelasDTO,
                evento.getValorTotal(),
                evento.getMotivoBaixa()
        );
    }


    private ParcelaRequestDTO toParcelaDTO(EventoParcela eventoParcela) {
        if (eventoParcela == null) return null;

        return new ParcelaRequestDTO(
                eventoParcela.getNumeroParcela(),
                eventoParcela.getDataVencimento(),
                eventoParcela.getValor()
        );
    }
}

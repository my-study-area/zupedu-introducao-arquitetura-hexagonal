package br.com.estudo.custodia.adapter.out.dto;

import br.com.estudo.custodia.ParcelaRequestDTO;

import java.math.BigDecimal;
import java.util.List;

public record LiquidacaoRequestDTO(
        String numeroContrato,

        List<ParcelaRequestDTO> fluxoParcelas,

        BigDecimal valorTotal,

        Integer motivoBaixa
) {
}

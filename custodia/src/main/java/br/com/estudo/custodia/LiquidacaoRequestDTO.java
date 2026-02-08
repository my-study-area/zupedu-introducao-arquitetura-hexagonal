package br.com.estudo.custodia;

import java.math.BigDecimal;
import java.util.List;

public record LiquidacaoRequestDTO(
        String numeroContrato,

        List<ParcelaRequestDTO> fluxoParcelas,

        BigDecimal valorTotal,

        Integer motivoBaixa
) {
}

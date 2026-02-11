package br.com.estudo.custodia.adapter.dto.api;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ParcelaRequestDTO(
        int numeroParcela,

        LocalDate dataVencimento,

        BigDecimal valor
) {
}

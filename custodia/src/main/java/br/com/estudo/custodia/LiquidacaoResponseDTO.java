package br.com.estudo.custodia;

public record LiquidacaoResponseDTO(
        int statusCode,
        String numeroContrato
) {
}

package br.com.estudo.custodia.port.out;

import java.util.Objects;
import java.util.Optional;

public class BuscaContratoModernizadoRepository {
    Optional<CustodiaNumeroOperacao> findById(String numeroContratoLegado, String siglaSistemaOrigemOperacao) {
        if (Objects.equals(numeroContratoLegado, "123")) {
            return Optional.empty();
        }
        CustodiaNumeroOperacao custodiaNumeroOperacao = CustodiaNumeroOperacao.builder()
                .numeroContratoLegado("0123")
                .numeroContratoModernizado("1111")
                .siglaSistemaOrigemOperacao("ABC")
                .build();
        return Optional.of(custodiaNumeroOperacao);
    }
}

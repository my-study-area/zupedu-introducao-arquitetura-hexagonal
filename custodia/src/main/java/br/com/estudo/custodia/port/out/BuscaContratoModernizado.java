package br.com.estudo.custodia.port.out;

import java.util.Optional;

public interface BuscaContratoModernizado {
    Optional<CustodiaNumeroOperacao> findById(String numeroContratoLegado, String siglaSistemaOrigemOperacao);
}

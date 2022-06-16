package br.com.zup.edu.exemplohexagonal.domain.ports;

import org.springframework.stereotype.Component;

@Component
public interface TaxaRepository {
    double pegarTaxaPara(double valor);
}

package br.com.zup.edu.exemplohexagonal.adapters;

import br.com.zup.edu.exemplohexagonal.domain.ports.TaxaRepository;

public class TestTaxaRepositoryAdapter implements TaxaRepository {
    @Override
    public double pegarTaxaPara(double valor) {
        return 0.1;
    }
}

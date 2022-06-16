package br.com.zup.edu.exemplohexagonal.adapters;

import br.com.zup.edu.exemplohexagonal.domain.ports.TaxaRepository;
import org.springframework.stereotype.Component;

@Component
public class MockTaxaRepository implements TaxaRepository {
    @Override
    public double pegarTaxaPara(double valor) {
        if (valor > 100) return 0.1;
        return 0.05;
    }
}

package br.com.zup.edu.exemplohexagonal.domain;

import br.com.zup.edu.exemplohexagonal.domain.ports.TaxaRepository;

public class Desconto {

    private TaxaRepository repository;

    public Desconto(TaxaRepository repository) {
        this.repository = repository;
    }

    public double calcular(double valor) {
        var taxa = repository.pegarTaxaPara(valor);
        return valor * taxa;
    }
}

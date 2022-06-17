package br.com.zup.edu.exemplohexagonal.domain;

import br.com.zup.edu.exemplohexagonal.adapters.TestTaxaRepositoryAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DescontoTest {

    @Test
    @DisplayName("deve Calcular O Desconto Quando O valor For Positivo")
    void deveCalcularODescontoQuandoOvalorForPositivo() {
        var desconto = new Desconto(new TestTaxaRepositoryAdapter());
        var valorDoDesconto = desconto.calcular(100);
        Assertions.assertEquals(10, valorDoDesconto);
    }
}
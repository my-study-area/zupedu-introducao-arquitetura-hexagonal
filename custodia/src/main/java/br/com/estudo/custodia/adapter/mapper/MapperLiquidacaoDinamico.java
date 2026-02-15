package br.com.estudo.custodia.adapter.mapper;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoBase;
import br.com.estudo.custodia.core.domain.Liquidacao;

/**
 * Interface para mapeamento dinâmico de objetos de liquidação.
 * <p>
 * Implementações desta interface devem ser capazes de:
 * <ul>
 *   <li>Converter um objeto genérico de liquidação para o domínio {@link Liquidacao}.</li>
 *   <li>Indicar dinamicamente se podem manipular determinado {@link EventoBase}.</li>
 * </ul>
 * <p>
 * Esta interface é útil em cenários onde múltiplos tipos de liquidação precisam ser tratados
 * por diferentes mappers, selecionados em tempo de execução.
 *
 * <pre>
 * Exemplo de uso:
 * MapperLiquidacaoDinamico mapper = factory.getMapper(eventoBase);
 * Liquidacao liquidacao = mapper.toModel(objeto);
 * </pre>
 *
 */
public interface MapperLiquidacaoDinamico {

    /**
     * Converte um objeto de liquidação para o domínio {@link Liquidacao}.
     *
     * @param liquidacao objeto a ser convertido
     * @return instância de {@link Liquidacao}
     */
    Liquidacao toModel(Object liquidacao);

    /**
     * Indica se este mapper pode manipular o evento informado.
     *
     * @param eventoBase evento a ser avaliado
     * @return {@code true} se este mapper pode manipular o evento, {@code false} caso contrário
     */
    boolean canHandle(EventoBase eventoBase);
}
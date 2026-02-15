package br.com.estudo.custodia.port.out;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class BuscaContratoModernizadoMemoriaAdapter implements BuscaContratoModernizado {
    private static final Logger logger = LoggerFactory.getLogger(BuscaContratoModernizadoMemoriaAdapter.class);
    private BuscaContratoModernizadoRepository repository;

    public BuscaContratoModernizadoMemoriaAdapter(BuscaContratoModernizadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<CustodiaNumeroOperacao> findById(String numeroContratoLegado, String siglaSistemaOrigemOperacao) {
        logger.info("Buscando contrato modernizado para o contrato legado {} com a sigla {}",
                numeroContratoLegado,
                siglaSistemaOrigemOperacao);
        return repository.findById(numeroContratoLegado, siglaSistemaOrigemOperacao);
    }
}

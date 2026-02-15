package br.com.estudo.custodia.adapter.mapper;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoBase;

import java.util.List;

public class LiquidacaoMapperFactory {
    private final List<LiquidacaoMapper> mappers;

    public LiquidacaoMapperFactory(List<LiquidacaoMapper> mappers) {
        this.mappers = mappers;
    }

    public LiquidacaoMapper build(EventoBase evento) {
      return  mappers.stream()
              .filter(mapper -> mapper.isValid(evento))
              .findFirst()
              .orElseThrow(() -> new RuntimeException("Mapper de liquidação não encontrado"));
    }
}

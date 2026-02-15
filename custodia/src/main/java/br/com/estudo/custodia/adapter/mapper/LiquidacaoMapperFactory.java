package br.com.estudo.custodia.adapter.mapper;

import br.com.estudo.custodia.adapter.dto.mensageria.EventoBase;

import java.util.List;

public class LiquidacaoMapperFactory {
    private final List<MapperLiquidacaoDinamico> mappers;

    public LiquidacaoMapperFactory(List<MapperLiquidacaoDinamico> mappers) {
        this.mappers = mappers;
    }

    public MapperLiquidacaoDinamico build(EventoBase evento) {
      return  mappers.stream()
              .filter(mapper -> mapper.canHandle(evento))
              .findFirst()
              .orElseThrow(() -> new RuntimeException("Mapper de liquidação não encontrado"));
    }
}

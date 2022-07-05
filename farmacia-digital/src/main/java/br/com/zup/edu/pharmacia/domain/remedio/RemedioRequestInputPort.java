package br.com.zup.edu.pharmacia.domain.remedio;

import br.com.zup.edu.pharmacia.domain.categoria.Categoria;

public interface RemedioRequestInputPort {
    Remedio toModel(Categoria categoria);
}

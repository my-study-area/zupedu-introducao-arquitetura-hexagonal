package com.zupedu.bancodigital.domain.correntista;

import java.util.Optional;

public interface CorrentistaRepositoryPort {
    Correntista cadastrar(Correntista correntista);
    Optional<Correntista> buscarPorId(Long correntistaId);
}

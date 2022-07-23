package com.zupedu.bancodigital.adapters.repository;

import com.zupedu.bancodigital.domain.correntista.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista, Long> {
}

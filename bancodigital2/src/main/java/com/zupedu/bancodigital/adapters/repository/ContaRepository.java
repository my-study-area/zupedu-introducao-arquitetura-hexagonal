package com.zupedu.bancodigital.adapters.repository;

import com.zupedu.bancodigital.domain.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}

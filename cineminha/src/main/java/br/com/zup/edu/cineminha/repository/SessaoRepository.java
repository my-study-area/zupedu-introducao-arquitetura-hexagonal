package br.com.zup.edu.cineminha.repository;

import br.com.zup.edu.cineminha.model.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {
}
package br.com.zup.edu.cineminha.adapters.persistence;

import br.com.zup.edu.cineminha.domain.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {
}

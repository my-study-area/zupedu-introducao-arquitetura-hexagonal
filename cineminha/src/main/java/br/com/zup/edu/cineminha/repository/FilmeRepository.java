package br.com.zup.edu.cineminha.repository;

import br.com.zup.edu.cineminha.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}

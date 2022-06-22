package com.zupedu.bancodigital.adapters.persistence;

import com.zupedu.bancodigital.domain.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {
}

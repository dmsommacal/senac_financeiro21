package com.rh.financeiro.repository;

import com.rh.financeiro.model.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepository
        extends JpaRepository<Entrada, Long> {
}

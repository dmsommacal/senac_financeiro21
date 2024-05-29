package com.rh.financeiro.repository;

import com.rh.financeiro.model.Dependentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependentesRepository
        extends JpaRepository<Dependentes, Long> {
}
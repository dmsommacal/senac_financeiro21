package com.rh.financeiro.repository;

import com.rh.financeiro.model.ExperienciaAnterior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaAnteriorRepository
        extends JpaRepository<ExperienciaAnterior, Long> {
}

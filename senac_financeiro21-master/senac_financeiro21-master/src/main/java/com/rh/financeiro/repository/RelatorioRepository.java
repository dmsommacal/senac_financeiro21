package com.rh.financeiro.repository;

import com.rh.financeiro.model.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioRepository
        extends JpaRepository<Relatorio, Long> {
}
package com.rh.financeiro.repository;

import com.rh.financeiro.model.DadosBancarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosBancariosRepository
        extends JpaRepository<DadosBancarios, Long> {
}
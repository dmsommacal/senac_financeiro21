package com.rh.financeiro.repository;

import com.rh.financeiro.model.Filiacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiliacaoRepository
        extends JpaRepository<Filiacao, Long> {
}

package com.rh.financeiro.repository;

import com.rh.financeiro.model.Certificacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificacoesRepository
        extends JpaRepository<Certificacoes, Long> {
}
package com.rh.financeiro.repository;

import com.rh.financeiro.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoRepository
        extends JpaRepository<Solicitacao, Long> {
}

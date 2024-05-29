package com.rh.financeiro.repository;

import com.rh.financeiro.model.FolhaRescisao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolhaRescisaoRepository
        extends JpaRepository<FolhaRescisao, Long> {
}

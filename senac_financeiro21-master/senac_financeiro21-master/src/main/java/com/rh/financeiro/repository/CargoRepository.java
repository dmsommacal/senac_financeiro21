package com.rh.financeiro.repository;

import com.rh.financeiro.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository
        extends JpaRepository<Cargo, Long> {
}
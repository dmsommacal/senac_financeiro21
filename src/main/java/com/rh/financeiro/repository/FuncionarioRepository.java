package com.rh.financeiro.repository;

import com.rh.financeiro.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository
    extends JpaRepository<Funcionario, Long>{
}

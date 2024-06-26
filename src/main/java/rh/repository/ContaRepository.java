package rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rh.enterprise.CustomQuerydslPredicateExecutor;
import rh.model.Conta;

public interface ContaRepository extends JpaRepository <Conta, Long>, CustomQuerydslPredicateExecutor<Conta> {
}

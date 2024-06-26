package rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rh.enterprise.CustomQuerydslPredicateExecutor;
import rh.model.FolhaPagamento;

@Repository
public interface FolhaPagamentoRepository extends JpaRepository<FolhaPagamento, Long>, CustomQuerydslPredicateExecutor<FolhaPagamento> {
}

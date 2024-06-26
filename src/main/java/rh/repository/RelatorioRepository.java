package rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rh.enterprise.CustomQuerydslPredicateExecutor;
import rh.model.Relatorio;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Long>, CustomQuerydslPredicateExecutor<Relatorio> {
}

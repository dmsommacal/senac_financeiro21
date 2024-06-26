package rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rh.enterprise.CustomQuerydslPredicateExecutor;
import rh.model.Filiacao;

@Repository
public interface FiliacaoRepository extends JpaRepository<Filiacao, Long>, CustomQuerydslPredicateExecutor<Filiacao> {
}

package rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rh.enterprise.CustomQuerydslPredicateExecutor;
import rh.model.DadoBancario;

@Repository
public interface DadoBancarioRepository extends JpaRepository<DadoBancario, Long>, CustomQuerydslPredicateExecutor<DadoBancario> {

}

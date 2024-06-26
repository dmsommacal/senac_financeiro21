package rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rh.enterprise.CustomQuerydslPredicateExecutor;
import rh.model.Dependente;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long>, CustomQuerydslPredicateExecutor<Dependente> {


}


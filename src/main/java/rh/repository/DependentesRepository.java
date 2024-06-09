package rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rh.model.Dependentes;

@Repository
public interface DependentesRepository extends JpaRepository<Dependentes, Long> {


}


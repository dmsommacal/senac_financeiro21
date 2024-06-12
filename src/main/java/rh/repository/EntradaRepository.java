package rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rh.model.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {

}

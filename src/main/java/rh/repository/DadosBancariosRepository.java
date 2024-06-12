package rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rh.model.DadosBancarios;

@Repository
public interface DadosBancariosRepository extends JpaRepository<DadosBancarios, Long> {

}

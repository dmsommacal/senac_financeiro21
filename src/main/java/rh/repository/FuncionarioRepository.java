package rh.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rh.enterprise.CustomQuerydslPredicateExecutor;
import rh.model.Funcionario;
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>, CustomQuerydslPredicateExecutor<Funcionario> {
    Page<Funcionario> findByNome(String nome, Pageable pageable);
    Page<Funcionario> findByCpf(String cpf, Pageable pageable);
}

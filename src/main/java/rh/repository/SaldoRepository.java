package rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rh.model.Saldo;

public interface SaldoRepository extends JpaRepository <Saldo, Long> {
}

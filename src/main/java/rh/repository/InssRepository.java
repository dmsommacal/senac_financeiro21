package rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rh.model.Inss;

import java.util.List;

public interface InssRepository extends JpaRepository<Inss, Long> {
}

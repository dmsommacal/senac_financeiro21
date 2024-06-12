package rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rh.model.ExperienciaAnterior;

@Repository
public interface ExperienciaAnteriorRepository extends JpaRepository<ExperienciaAnterior, Long> {
}

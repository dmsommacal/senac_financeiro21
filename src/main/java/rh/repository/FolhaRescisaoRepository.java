package rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rh.enterprise.CustomQuerydslPredicateExecutor;
import rh.model.FolhaRescisao;

@Repository
public interface FolhaRescisaoRepository extends JpaRepository<FolhaRescisao, Long>, CustomQuerydslPredicateExecutor<FolhaRescisao> {
}

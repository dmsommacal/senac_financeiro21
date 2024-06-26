package rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rh.enterprise.CustomQuerydslPredicateExecutor;
import rh.model.Certificacao;

@Repository
public interface CertificacaoRepository extends JpaRepository <Certificacao, Long>, CustomQuerydslPredicateExecutor<Certificacao> {
}



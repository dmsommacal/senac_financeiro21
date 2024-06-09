package rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rh.model.Certificacoes;

@Repository
public interface CertificacoesRepository extends JpaRepository <Certificacoes, Long> {
}


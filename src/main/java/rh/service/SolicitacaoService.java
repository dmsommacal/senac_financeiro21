package rh.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.enterprise.ValidationException;
import rh.model.Saldo;
import rh.model.Solicitacao;
import rh.repository.SaldoRepository;
import rh.repository.SolicitacaoRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private SaldoRepository saldoRepository;

    @Transactional
    public Solicitacao salvar(Solicitacao entity) {

        Saldo saldo = saldoRepository.findById(1L).orElseThrow(() -> new ValidationException("Saldo não identificado!"));
        saldo.setValorDisponivel(saldo.getValorDisponivel().subtract(entity.getValorSolicitado()));
        saldoRepository.save(saldo);

        entity.setSaldo(saldo);
        return solicitacaoRepository.save(entity);
    }

    public List<Solicitacao> buscaTodos(){
        return solicitacaoRepository.findAll();
    }
    public Solicitacao buscaPorId(Long id){
        return solicitacaoRepository.findById(id).orElse(null);
    }

    public Solicitacao alterar(Long id, Solicitacao alterado){
        Optional<Solicitacao> encontrado = solicitacaoRepository.findById(id);
        if (encontrado.isPresent()){
            Solicitacao solicitacao = encontrado.get();


            return solicitacaoRepository.save(solicitacao);
        }
        return null;
    }
    public void remover(Long id) {
        solicitacaoRepository.deleteById(id);
    }
}

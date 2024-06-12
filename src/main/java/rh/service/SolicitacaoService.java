package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.enterprise.ValidationException;
import rh.model.Saldo;
import rh.model.Solicitacao;
import rh.repository.SaldoRepository;
import rh.repository.SolicitacaoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private SaldoRepository saldoRepository;

    public Solicitacao salvar(Solicitacao entity){

        Saldo saldo = entity.getSaldo();

        if (entity.getValorSolicitado() > saldo.getValorDisponivel()){
            throw new ValidationException("O saldo solicitado é maior do que o disponível!!!");
        }

        saldo.setValorDisponivel(saldo.getValorDisponivel() - entity.getValorSolicitado());
        saldoRepository.save(saldo);

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

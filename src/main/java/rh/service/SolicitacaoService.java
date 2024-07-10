package rh.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.enterprise.ValidationException;
import rh.model.Conta;
import rh.model.Relatorio;
import rh.model.Solicitacao;
import rh.repository.ContaRepository;
import rh.repository.RelatorioRepository;
import rh.repository.SolicitacaoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private RelatorioRepository relatorioRepository;

    @Transactional
    public Solicitacao salvar(Solicitacao entity) {

            Conta conta = contaRepository.findById(1L).orElseThrow(() -> new ValidationException("Conta do Financeiro não identificada!"));

            if (entity.getValorSolicitado().compareTo(conta.getSaldo() ) < 0){
            //Altera e salva o saldo a cada solicitação
            conta.setSaldo(conta.getSaldo().subtract(entity.getValorSolicitado()));
            contaRepository.save(conta);
            entity.setConta(conta);

            //Altera e salva a solicitação no relatório
            Relatorio relatorio = new Relatorio();
            entity.setRelatorio(relatorio);
            relatorioRepository.save(relatorio);
            }else {
                throw new ValidationException("A solicitação não pode ser maior que o saldo em conta");
            }
            return solicitacaoRepository.save(entity);
    }

    public List<Solicitacao> buscaTodos(){
        return solicitacaoRepository.findAll();
    }
    public Solicitacao buscaPorId(Long id){
        return solicitacaoRepository.findById(id).orElse(null);
    }
}

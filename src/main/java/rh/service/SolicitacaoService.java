package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.model.Solicitacao;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    public Solicitacao salvar(Solicitacao entity){
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

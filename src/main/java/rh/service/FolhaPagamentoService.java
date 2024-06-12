package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.model.FolhaPagamento;
import rh.repository.FolhaPagamentoRepository;

import java.util.List;
import java.util.Optional;
@Service
public class FolhaPagamentoService {

    @Autowired
    private FolhaPagamentoRepository folhaPagamentoRepository;

    public FolhaPagamento salvar(FolhaPagamento entity){

        return folhaPagamentoRepository.save(entity);
    }

    public List<FolhaPagamento> buscaTodos(){
        return folhaPagamentoRepository.findAll();
    }
    public FolhaPagamento buscaPorId(Long id){
        return folhaPagamentoRepository.findById(id).orElse(null);
    }

    public FolhaPagamento alterar(Long id, FolhaPagamento alterado){
        Optional<FolhaPagamento> encontrado = folhaPagamentoRepository.findById(id);
        if (encontrado.isPresent()){
            FolhaPagamento folhaPagamento = encontrado.get();

            return folhaPagamentoRepository.save(folhaPagamento);
        }
        return null;
    }
    public void remover(Long id) {
        folhaPagamentoRepository.deleteById(id);
    }
}

package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.model.FolhaRescisao;
import rh.repository.FolhaPagamentoRepository;
import rh.repository.FolhaRescisaoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FolhaRescisaoService {

    @Autowired
    private FolhaRescisaoRepository folhaRescicaoRepository;

    public FolhaRescisao salvar(FolhaRescisao entity){

        return folhaRescicaoRepository.save(entity);
    }

    public List<FolhaRescisao> buscaTodos(){
        return folhaRescicaoRepository.findAll();
    }
    public FolhaRescisao buscaPorId(Long id){
        return folhaRescicaoRepository.findById(id).orElse(null);
    }

    public FolhaRescisao alterar(Long id, FolhaRescisao alterado){
        Optional<FolhaRescisao> encontrado = folhaRescicaoRepository.findById(id);
        if (encontrado.isPresent()){
            FolhaRescisao folhaRescisao = encontrado.get();

            return folhaRescicaoRepository.save(folhaRescisao);
        }
        return null;
    }
    public void remover(Long id) {
        folhaRescicaoRepository.deleteById(id);
    }
}

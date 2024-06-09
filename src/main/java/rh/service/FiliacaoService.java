package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.model.Filiacao;

import java.util.List;
import java.util.Optional;

@Service
public class FiliacaoService {

    @Autowired
    private FiliacaoRepository filiacaoRepository;

    public Filiacao salvar(Filiacao entity){

        return filiacaoRepository.save(entity);
    }

    public List<Filiacao> buscaTodos(){
        return filiacaoRepository.findAll();
    }
    public Filiacao buscaPorId(Long id){
        return filiacaoRepository.findById(id).orElse(null);
    }

    public Filiacao alterar(Long id, Filiacao alterado){
        Optional<Filiacao> encontrado = filiacaoRepository.findById(id);
        if (encontrado.isPresent()){
            Filiacao filiacao = encontrado.get();


            return filiacaoRepository.save(filiacao);
        }
        return null;
    }
    public void remover(Long id) {
        filiacaoRepository.deleteById(id);
    }
}

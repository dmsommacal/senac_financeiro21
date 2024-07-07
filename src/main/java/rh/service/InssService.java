package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.model.Inss;
import rh.repository.InssRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InssService {
    @Autowired
    private InssRepository inssRepository;
    public Inss salvar(Inss entity){
        return inssRepository.save(entity);
    }
    public List<Inss> buscaTodos(){
        return inssRepository.findAll();
    }
    public Inss buscaPorId(Long id){
        return inssRepository.findById(id).orElse(null);
    }

    public Inss alterar(Long id, Inss alterado){
        Optional<Inss> encontrado = inssRepository.findById(id);
        if (encontrado.isPresent()){
            Inss inss = encontrado.get();
            return inssRepository.save(inss);
        }
        return null;
    }
    public void remover(Long id) {
        inssRepository.deleteById(id);
    }
}

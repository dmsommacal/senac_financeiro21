package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.model.Irrf;
import rh.repository.IrrfRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IrrfService {
    @Autowired
    private IrrfRepository irrfRepository;
    public Irrf salvar(Irrf entity){
        return irrfRepository.save(entity);
    }
    public List<Irrf> buscaTodos(){
        return irrfRepository.findAll();
    }
    public Irrf buscaPorId(Long id){
        return irrfRepository.findById(id).orElse(null);
    }
    public Irrf alterar(Long id, Irrf alterado){
        Optional<Irrf> encontrado = irrfRepository.findById(id);
        if (encontrado.isPresent()){
            Irrf irrf = encontrado.get();
            return irrfRepository.save(irrf);
        }
        return null;
    }
    public void remover(Long id) {
        irrfRepository.deleteById(id);
    }
}

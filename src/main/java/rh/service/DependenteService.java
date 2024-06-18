package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.model.Dependente;
import rh.repository.DependenteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;

    public Dependente salvar(Dependente entity){
        return dependenteRepository.save(entity);
    }

    public List<Dependente> buscaTodos(){
        return dependenteRepository.findAll();
    }
    public Dependente buscaPorId(Long id){
        return dependenteRepository.findById(id).orElse(null);
    }

    public Dependente alterar(Long id, Dependente alterado){
        Optional<Dependente> encontrado = dependenteRepository.findById(id);
        if (encontrado.isPresent()){
            Dependente dependente = encontrado.get();


            return dependenteRepository.save(dependente);
        }
        return null;
    }
    public void remover(Long id) {
        dependenteRepository.deleteById(id);
    }
}

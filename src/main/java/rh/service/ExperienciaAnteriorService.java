package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.model.ExperienciaAnterior;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaAnteriorService {

    @Autowired
    private ExperienciaAnteriorRepository experienciaAnteriorRepository;

    public ExperienciaAnterior salvar(ExperienciaAnterior entity){

        return experienciaAnteriorRepository.save(entity);
    }

    public List<ExperienciaAnterior> buscaTodos(){
        return experienciaAnteriorRepository.findAll();
    }
    public ExperienciaAnterior buscaPorId(Long id){
        return experienciaAnteriorRepository.findById(id).orElse(null);
    }

    public ExperienciaAnterior alterar(Long id, ExperienciaAnterior alterado){
        Optional<ExperienciaAnterior> encontrado = experienciaAnteriorRepository.findById(id);
        if (encontrado.isPresent()){
            ExperienciaAnterior ExperienciaAnterior = encontrado.get();


            return experienciaAnteriorRepository.save(ExperienciaAnterior);
        }
        return null;
    }
    public void remover(Long id) {
        experienciaAnteriorRepository.deleteById(id);
    }
}

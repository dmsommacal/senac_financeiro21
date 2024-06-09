package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.enterprise.ValidationException;
import rh.model.Entrada;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    public Entrada salvar(Entrada entity){
        if (entity.getValor() == 0.0 || entity.getDescricao().isBlank()){
            throw new ValidationException("A entrada tem que ter um valor e uma descrição.");
        }
        return entradaRepository.save(entity);
    }

    public List<Entrada> buscaTodos(){
        return entradaRepository.findAll();
    }
    public Entrada buscaPorId(Long id){
        return entradaRepository.findById(id).orElse(null);
    }

    public Entrada alterar(Long id, Entrada alterado){
        Optional<Entrada> encontrado = entradaRepository.findById(id);
        if (encontrado.isPresent()){
            Entrada entrada = encontrado.get();


            return entradaRepository.save(entrada);
        }
        return null;
    }
    public void remover(Long id) {
        entradaRepository.deleteById(id);
    }
}

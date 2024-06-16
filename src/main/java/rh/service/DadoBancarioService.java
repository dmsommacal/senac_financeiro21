package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.model.DadoBancario;
import rh.repository.DadoBancarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DadoBancarioService {

    @Autowired
    private DadoBancarioRepository dadoBancarioRepository;

    public DadoBancario salvar(DadoBancario entity){

        return dadoBancarioRepository.save(entity);
    }

    public List<DadoBancario> buscaTodos(){
        return dadoBancarioRepository.findAll();
    }
    public DadoBancario buscaPorId(Long id){
        return dadoBancarioRepository.findById(id).orElse(null);
    }

    public DadoBancario alterar(Long id, DadoBancario alterado){
        Optional<DadoBancario> encontrado = dadoBancarioRepository.findById(id);
        if (encontrado.isPresent()){
            DadoBancario dadoBancario = encontrado.get();

            return dadoBancarioRepository.save(dadoBancario);
        }
        return null;
    }
    public void remover(Long id) {
        dadoBancarioRepository.deleteById(id);
    }
}

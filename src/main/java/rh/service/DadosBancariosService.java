package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.model.DadosBancarios;
import rh.repository.DadosBancariosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DadosBancariosService {

    @Autowired
    private DadosBancariosRepository dadosBancariosRepository;

    public DadosBancarios salvar(DadosBancarios entity){

        return dadosBancariosRepository.save(entity);
    }

    public List<DadosBancarios> buscaTodos(){
        return dadosBancariosRepository.findAll();
    }
    public DadosBancarios buscaPorId(Long id){
        return dadosBancariosRepository.findById(id).orElse(null);
    }

    public DadosBancarios alterar(Long id, DadosBancarios alterado){
        Optional<DadosBancarios> encontrado = dadosBancariosRepository.findById(id);
        if (encontrado.isPresent()){
            DadosBancarios dadosBancarios = encontrado.get();

            return dadosBancariosRepository.save(dadosBancarios);
        }
        return null;
    }
    public void remover(Long id) {
        dadosBancariosRepository.deleteById(id);
    }
}

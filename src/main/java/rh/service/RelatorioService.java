package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.model.Relatorio;
import rh.repository.RelatorioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository relatorioRepository;

    public Relatorio salvar(Relatorio entity){

        return relatorioRepository.save(entity);
    }

    public List<Relatorio> buscaTodos(){
        return relatorioRepository.findAll();
    }
    public Relatorio buscaPorId(Long id){
        return relatorioRepository.findById(id).orElse(null);
    }

    public Relatorio alterar(Long id, Relatorio alterado){
        Optional<Relatorio> encontrado = relatorioRepository.findById(id);
        if (encontrado.isPresent()){
            Relatorio relatorio = encontrado.get();

            return relatorioRepository.save(relatorio);
        }
        return null;
    }
    public void remover(Long id) {
        relatorioRepository.deleteById(id);
    }
}

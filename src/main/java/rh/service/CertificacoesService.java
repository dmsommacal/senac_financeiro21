package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.model.Certificacoes;
import rh.repository.CertificacoesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CertificacoesService {

    @Autowired
    private CertificacoesRepository certificacoesRepository;

    public Certificacoes salvar(Certificacoes entity){
        return certificacoesRepository.save(entity);
    }

    public List<Certificacoes> buscaTodos(){
        return certificacoesRepository.findAll();
    }
    public Certificacoes buscaPorId(Long id){
        return certificacoesRepository.findById(id).orElse(null);
    }

    public Certificacoes alterar(Long id, Certificacoes alterado){
        Optional<Certificacoes> encontrado = certificacoesRepository.findById(id);
        if (encontrado.isPresent()){
            Certificacoes certificacoes = encontrado.get();

            return certificacoesRepository.save(certificacoes);
        }
        return null;
    }
    public void remover(Long id) {
        certificacoesRepository.deleteById(id);
    }
}

package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.model.Certificacao;
import rh.repository.CertificacaoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CertificacaoService {

    @Autowired
    private CertificacaoRepository certificacaoRepository;

    public Certificacao salvar(Certificacao entity){
        return certificacaoRepository.save(entity);
    }

    public List<Certificacao> buscaTodos(){
        return certificacaoRepository.findAll();
    }
    public Certificacao buscaPorId(Long id){
        return certificacaoRepository.findById(id).orElse(null);
    }

    public Certificacao alterar(Long id, Certificacao alterado){
        Optional<Certificacao> encontrado = certificacaoRepository.findById(id);
        if (encontrado.isPresent()){
            Certificacao certificacoes = encontrado.get();

            return certificacaoRepository.save(certificacoes);
        }
        return null;
    }
    public void remover(Long id) {
        certificacaoRepository.deleteById(id);
    }
}

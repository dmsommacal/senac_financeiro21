package rh.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.enterprise.ValidationException;
import rh.model.Conta;
import rh.repository.ContaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;
    @PostConstruct
    public void iniciaConta() {
        if (!contaRepository.existsById(1L)) {
            Conta conta = new Conta();
            conta.setId(1L);
            conta.setSaldo(BigDecimal.ZERO);
            contaRepository.save(conta);
        }
    }
    public Conta salvar(Conta entity){

        if (entity.getSaldo() != null && entity.getSaldo().compareTo(BigDecimal.ZERO) != 0){
            throw new ValidationException("Já existe uma conta cadastrada!");
        }
        return contaRepository.save(entity);
    }
    public List<Conta> buscaTodos(){
        return contaRepository.findAll();
    }
    public Conta buscaPorId(Long id){
        return contaRepository.findById(id).orElse(null);
    }

    public Conta alterar(Long id, Conta alterado){
        Optional<Conta> encontrado = contaRepository.findById(id);
        if (encontrado.isPresent()){
            Conta conta = encontrado.get();
            return contaRepository.save(conta);
        }
        return null;
    }
    public void remover(Long id) {
        contaRepository.deleteById(id);
    }
}

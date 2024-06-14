package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.enterprise.ValidationException;
import rh.model.Saldo;
import rh.repository.SaldoRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Service
public class SaldoService {
    @Autowired
    private SaldoRepository saldoRepository;
    public Saldo salvar(Saldo entity){
        if (entity.getValorDisponivel() != null && entity.getValorDisponivel().compareTo(BigDecimal.ZERO) != 0){
            throw new ValidationException("Já existe um saldo cadastrado!");
        }
        return saldoRepository.save(entity);
    }
    public List<Saldo> buscaTodos(){
        return saldoRepository.findAll();
    }
    public Saldo buscaPorId(Long id){
        return saldoRepository.findById(id).orElse(null);
    }

    public Saldo alterar(Long id, Saldo alterado){
        Optional<Saldo> encontrado = saldoRepository.findById(id);
        if (encontrado.isPresent()){
            Saldo saldo = encontrado.get();
            return saldoRepository.save(saldo);
        }
        return null;
    }
    public void remover(Long id) {
        saldoRepository.deleteById(id);
    }
}

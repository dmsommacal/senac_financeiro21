package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.model.Saldo;
import rh.repository.SaldoRepository;

import java.util.List;
import java.util.Optional;
@Service
public class SaldoService {
    @Autowired
    private SaldoRepository saldoRepository;

    public Saldo salvar(Saldo entity){
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

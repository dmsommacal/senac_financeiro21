package rh.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.enterprise.ValidationException;
import rh.model.Entrada;
import rh.model.Relatorio;
import rh.model.Conta;
import rh.repository.EntradaRepository;
import rh.repository.RelatorioRepository;
import rh.repository.ContaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaService {
    @Autowired
    private EntradaRepository entradaRepository;
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private RelatorioRepository relatorioRepository;
    @Transactional
    public Entrada salvar(Entrada entity) {

        Conta conta = contaRepository.findById(1L).orElseThrow(() -> new ValidationException("Conta do Financeiro não identificada!"));

        //Altera e salva o saldo a cada entrada
        conta.setSaldo(conta.getSaldo().add(entity.getValor()));
        contaRepository.save(conta);
        entity.setConta(conta);

        //Aletra e salva a entrada no relatório
        Relatorio relatorio = new Relatorio();
        entity.setRelatorio(relatorio);
        relatorioRepository.save(relatorio);

        return entradaRepository.save(entity);
    }
    public List<Entrada> buscaTodos(){
        return entradaRepository.findAll();
    }
    public Entrada buscaPorId(Long id){
        return entradaRepository.findById(id).orElse(null);
    }

}

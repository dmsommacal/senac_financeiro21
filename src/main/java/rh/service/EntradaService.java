package rh.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.enterprise.ValidationException;
import rh.model.Entrada;
import rh.model.Relatorio;
import rh.model.Saldo;
import rh.repository.EntradaRepository;
import rh.repository.RelatorioRepository;
import rh.repository.SaldoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;
    @Autowired
    private SaldoRepository saldoRepository;
    @Autowired
    private RelatorioRepository relatorioRepository;
    @Transactional
    public Entrada salvar(Entrada entity) {
        Relatorio relatorio = new Relatorio();

        Saldo saldo = saldoRepository.findById(1L).orElseThrow(() -> new ValidationException("Saldo não identificado!"));

        //Altera e salva o valorDisponível do Saldo a cada Entrada
        saldo.setValorDisponivel(saldo.getValorDisponivel().add(entity.getValor()));
        saldoRepository.save(saldo);

        entity.setSaldo(saldo);

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

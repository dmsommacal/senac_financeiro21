package rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.model.FolhaPagamento;
import rh.model.Funcionario;
import rh.repository.FolhaPagamentoRepository;
import rh.repository.FuncionarioRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Service
public class FolhaPagamentoService {
    @Autowired
    private FolhaPagamentoRepository folhaPagamentoRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    public void calculaInss(FolhaPagamento folhaPagamento) {
        Optional<Funcionario> optional = funcionarioRepository.findById(folhaPagamento.getFuncionario().getId());

        Funcionario funcionario = optional.get();
        BigDecimal salarioContratual = funcionario.getSalarioContratual();

        BigDecimal aliquota1 = new BigDecimal("0.075");
        BigDecimal aliquota2 = new BigDecimal("0.09");
        BigDecimal aliquota3 = new BigDecimal("0.12");
        BigDecimal aliquota4 = new BigDecimal("0.14");

        BigDecimal deducao1 = new BigDecimal("21.18");
        BigDecimal deducao2 = new BigDecimal("101.18");
        BigDecimal deducao3 = new BigDecimal("181.18");
        BigDecimal deducao4 = new BigDecimal("908.85");

        if (salarioContratual.compareTo(BigDecimal.ZERO) >= 0 && salarioContratual.compareTo(new BigDecimal("1412")) <= 0) {
            folhaPagamento.setInss(salarioContratual.multiply(aliquota1));
        } else if (funcionario.getSalarioContratual().compareTo(new BigDecimal("1412.1")) >= 0 && salarioContratual.compareTo(new BigDecimal("2666.68")) <= 0) {
            folhaPagamento.setInss((salarioContratual.multiply(aliquota2).subtract(deducao1)));
        } else if (salarioContratual.compareTo(new BigDecimal("2666.69")) >= 0  && salarioContratual.compareTo(new BigDecimal("4000.03")) <= 0) {
            folhaPagamento.setInss(salarioContratual.multiply(aliquota3).subtract(deducao2));
        } else if (salarioContratual.compareTo(new BigDecimal("4000.04")) >= 0 && salarioContratual.compareTo(new BigDecimal("7776.02")) <= 0) {
            folhaPagamento.setInss(salarioContratual.multiply(aliquota4).subtract(deducao3));
        } else {
            folhaPagamento.setInss(deducao4);
        }
        folhaPagamento.setBaseIrrf(salarioContratual.subtract(folhaPagamento.getInss()));
    }
    public void calculaIrrf(FolhaPagamento folhaPagamento){
        Optional<Funcionario> optional = funcionarioRepository.findById(folhaPagamento.getFuncionario().getId());

        Funcionario funcionario = optional.get();
        BigDecimal baseIrrf = folhaPagamento.getBaseIrrf();

        BigDecimal aliquota1 = new BigDecimal("0.075");
        BigDecimal aliquota2 = new BigDecimal("0.15");
        BigDecimal aliquota3 = new BigDecimal("0.225");
        BigDecimal aliquota4 = new BigDecimal("0.275");

        BigDecimal deducao1 = new BigDecimal("158.40");
        BigDecimal deducao2 = new BigDecimal("370.40");
        BigDecimal deducao3 = new BigDecimal("651.73");
        BigDecimal deducao4 = new BigDecimal("884.96");

        if (baseIrrf.compareTo(BigDecimal.ZERO) >= 0 && baseIrrf.compareTo(new BigDecimal("2112")) <= 0) {
            folhaPagamento.setIrrf(BigDecimal.ZERO);
        } else if (funcionario.getSalarioContratual().compareTo(new BigDecimal("2112.1")) >= 0 && baseIrrf.compareTo(new BigDecimal("2826.65")) <= 0) {
            folhaPagamento.setIrrf((baseIrrf.multiply(aliquota1).subtract(deducao1)));
        } else if (baseIrrf.compareTo(new BigDecimal("2826.66")) >= 0  && baseIrrf.compareTo(new BigDecimal("3751.05")) <= 0) {
            folhaPagamento.setIrrf(baseIrrf.multiply(aliquota2).subtract(deducao2));
        } else if (baseIrrf.compareTo(new BigDecimal("3751.06")) >= 0 && baseIrrf.compareTo(new BigDecimal("4664.68")) <= 0) {
            folhaPagamento.setIrrf(baseIrrf.multiply(aliquota3).subtract(deducao3));
        } else {
            folhaPagamento.setIrrf((baseIrrf.multiply(aliquota4).subtract(deducao4)));
        }
    }
    public void calculaFolha(FolhaPagamento folhaPagamento){
        Optional<Funcionario> optional = funcionarioRepository.findById(folhaPagamento.getFuncionario().getId());
        Funcionario funcionario = optional.get();

        BigDecimal descontos = folhaPagamento.getInss().add(folhaPagamento.getIrrf());
        folhaPagamento.setSalarioLiquido(funcionario.getSalarioContratual().subtract(descontos));
    }
    public FolhaPagamento salvar(FolhaPagamento entity){
        calculaInss(entity);
        calculaIrrf(entity);
        calculaFolha(entity);
        return folhaPagamentoRepository.save(entity);
    }
    public List<FolhaPagamento> buscaTodos(){
        return folhaPagamentoRepository.findAll();
    }
    public FolhaPagamento buscaPorId(Long id){
        return folhaPagamentoRepository.findById(id).orElse(null);
    }

    public FolhaPagamento alterar(Long id, FolhaPagamento alterado){
        Optional<FolhaPagamento> encontrado = folhaPagamentoRepository.findById(id);
        if (encontrado.isPresent()){
            FolhaPagamento folhaPagamento = encontrado.get();

            return folhaPagamentoRepository.save(folhaPagamento);
        }
        return null;
    }
    public void remover(Long id) {
        folhaPagamentoRepository.deleteById(id);
    }
}

package rh.resource.dto;

import rh.model.FolhaPagamento;
import rh.model.Funcionario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FolhaPagamentoDTO {
   private Funcionario funcionario;
    private BigDecimal inss;
    private BigDecimal irrf;
    private BigDecimal baseIrrf;
    private BigDecimal salarioLiquido;

    public FolhaPagamentoDTO() {
    }
    public FolhaPagamentoDTO(Funcionario funcionario, BigDecimal inss, BigDecimal irrf, BigDecimal baseIrrf, BigDecimal salarioLiquido) {
        this.funcionario = funcionario;
        this.inss = inss;
        this.irrf = irrf;
        this.baseIrrf = baseIrrf;
        this.salarioLiquido = salarioLiquido;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public BigDecimal getInss() {
        return inss;
    }

    public void setInss(BigDecimal inss) {
        this.inss = inss;
    }

    public BigDecimal getIrrf() {
        return irrf;
    }

    public void setIrrf(BigDecimal irrf) {
        this.irrf = irrf;
    }

    public BigDecimal getBaseIrrf() {
        return baseIrrf;
    }

    public void setBaseIrrf(BigDecimal baseIrrf) {
        this.baseIrrf = baseIrrf;
    }

    public BigDecimal getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(BigDecimal salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public static FolhaPagamentoDTO fromEntity(FolhaPagamento folhaPagamento) {
        return new FolhaPagamentoDTO(
                folhaPagamento.getFuncionario(),
                folhaPagamento.getInss(),
                folhaPagamento.getIrrf(),
                folhaPagamento.getBaseIrrf(),
                folhaPagamento.getSalarioLiquido()
        );
    }

    public static List<FolhaPagamentoDTO> fromEntityList(List<FolhaPagamento> folhaPagamentos){
        List<FolhaPagamentoDTO> folhaPagamentoDTOList = new ArrayList<>();
        for (FolhaPagamento folhaPagamento : folhaPagamentos){
            folhaPagamentoDTOList.add(fromEntity(folhaPagamento));
        }
        return folhaPagamentoDTOList;
    }

    public FolhaPagamento toEntity() {
        FolhaPagamento folhaPagamento = new FolhaPagamento();
        folhaPagamento.setFuncionario(this.funcionario);
        folhaPagamento.setInss(this.inss);
        folhaPagamento.setIrrf(this.irrf);
        folhaPagamento.setBaseIrrf(this.baseIrrf);
        folhaPagamento.setSalarioLiquido(this.salarioLiquido);
        return folhaPagamento;
    }

    public static List<FolhaPagamento> toEntityList(List<FolhaPagamentoDTO> folhaPagamentoDTOS){
        List<FolhaPagamento> folhaPagamentos = new ArrayList<>();
        for (FolhaPagamentoDTO folhaPagamentoDTO: folhaPagamentoDTOS){
            folhaPagamentos.add(folhaPagamentoDTO.toEntity());
        }
        return folhaPagamentos;
    }
}

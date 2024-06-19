package rh.resource.dto;

import rh.model.Entrada;
import rh.model.Conta;
import rh.model.Solicitacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ContaDTO {

    private List<Entrada> entradas;

    private List<Solicitacao> solicitacoes;

    private BigDecimal saldo;

    public ContaDTO() {
    }

    public ContaDTO(List<Entrada> entradas, List<Solicitacao> solicitacoes, BigDecimal saldo) {
        this.entradas = entradas;
        this.solicitacoes = solicitacoes;
        this.saldo = saldo;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public List<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<Solicitacao> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public static ContaDTO fromEntity(Conta conta) {
        return new ContaDTO(
                conta.getEntradas(),
                conta.getSolicitacoes(),
                conta.getSaldo()
        );
    }
    public static List<ContaDTO> fromEntityList(List<Conta> contas){
        List<ContaDTO> contaDTOList = new ArrayList<>();
        for (Conta conta : contas){
            contaDTOList.add(fromEntity(conta));
        }
        return contaDTOList;
    }
    public Conta toEntity() {
        Conta conta = new Conta();
        conta.setEntradas(this.entradas);
        conta.setSolicitacoes(this.solicitacoes);
        conta.setSaldo(this.saldo);
        return conta;
    }
    public static List<Conta> toEntityList(List<ContaDTO> contaDTOS){
        List<Conta> contas = new ArrayList<>();
        for (ContaDTO contaDTO : contaDTOS){
            contas.add(contaDTO.toEntity());
        }
        return contas;
    }
}

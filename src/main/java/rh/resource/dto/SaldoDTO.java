package rh.resource.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import rh.model.Cargo;
import rh.model.Entrada;
import rh.model.Saldo;
import rh.model.Solicitacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SaldoDTO {

    private List<Entrada> entradas;

    private List<Solicitacao> solicitacoes;

    private BigDecimal valorDisponivel;

    public SaldoDTO() {
    }

    public SaldoDTO(List<Entrada> entradas, List<Solicitacao> solicitacoes, BigDecimal valorDisponivel) {
        this.entradas = entradas;
        this.solicitacoes = solicitacoes;
        this.valorDisponivel = valorDisponivel;
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

    public BigDecimal getValorDisponivel() {
        return valorDisponivel;
    }

    public void setValorDisponivel(BigDecimal valorDisponivel) {
        this.valorDisponivel = valorDisponivel;
    }
    public static SaldoDTO fromEntity(Saldo saldo) {
        return new SaldoDTO(
                saldo.getEntradas(),
                saldo.getSolicitacoes(),
                saldo.getValorDisponivel()
        );
    }
    public static List<SaldoDTO> fromEntityList(List<Saldo> saldos){
        List<SaldoDTO> saldoDTOList = new ArrayList<>();
        for (Saldo saldo : saldos){
            saldoDTOList.add(fromEntity(saldo));
        }
        return saldoDTOList;
    }
    public Saldo toEntity() {
        Saldo saldo = new Saldo();
        saldo.setEntradas(this.entradas);
        saldo.setSolicitacoes(this.solicitacoes);
        saldo.setValorDisponivel(this.valorDisponivel);
        return saldo;
    }
    public static List<Saldo> toEntityList(List<SaldoDTO> saldoDTOS){
        List<Saldo> saldos = new ArrayList<>();
        for (SaldoDTO saldoDTO : saldoDTOS){
            saldos.add(saldoDTO.toEntity());
        }
        return saldos;
    }
}

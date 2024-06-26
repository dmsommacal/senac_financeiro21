package rh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Conta extends EntityId{

    @OneToMany(mappedBy = "conta")
    @JsonIgnore
    private List<Entrada> entradas;
    @OneToMany(mappedBy = "conta")
    @JsonIgnore
    private List<Solicitacao> solicitacoes;
    @Column(nullable = false)
    private BigDecimal saldo;
    public Conta() {
    }

    public Conta(List<Entrada> entradas, List<Solicitacao> solicitacoes, BigDecimal saldo) {
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

    @Override
    public String toString() {
        return "Conta{" +
                "entradas=" + entradas +
                ", solicitacoes=" + solicitacoes +
                ", saldo=" + saldo +
                '}';
    }
}
package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Saldo extends EntityId{

    @OneToMany(mappedBy = "saldo")
    private List<Entrada> entradas;
    @OneToMany(mappedBy = "saldo")
    private List<Solicitacao> solicitacoes;
    @Column(nullable = false)
    private BigDecimal valorDisponivel;
    public Saldo() {
    }

    public Saldo(List<Entrada> entradas, List<Solicitacao> solicitacoes, BigDecimal valorDisponivel) {
        this.entradas = entradas;
        this.solicitacoes = solicitacoes;
        this.valorDisponivel = BigDecimal.ZERO;
    }
    @PrePersist
    public void iniciaSaldo(){
        setId(1L);
        if (this.valorDisponivel == null) {
            this.valorDisponivel = BigDecimal.ZERO;
        }
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

    @Override
    public String toString() {
        return "Saldo{" +
                "entradas=" + entradas +
                ", solicitacoes=" + solicitacoes +
                ", valorDisponivel=" + valorDisponivel +
                '}';
    }
}
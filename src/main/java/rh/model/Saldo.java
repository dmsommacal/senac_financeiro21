package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Saldo extends EntityId{
    @Column
    private Double valorDisponivel = 0.0;
    @OneToMany(mappedBy = "saldo")
    private List<Entrada> entradas;
    @OneToMany(mappedBy = "saldo")
    private List<Solicitacao> solicitacoes;

    public Saldo() {
    }

    public Saldo(Double valorDisponivel, List<Entrada> entradas) {
        this.valorDisponivel = valorDisponivel;
        this.entradas = entradas;
    }

    public Double getValorDisponivel() {
        return valorDisponivel;
    }

    public void setValorDisponivel(Double valorDisponivel) {
        this.valorDisponivel = valorDisponivel;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    @Override
    public String toString() {
        return "Saldo{" +
                "valorDisponivel=" + valorDisponivel +
                ", entradas=" + entradas +
                '}';
    }
}

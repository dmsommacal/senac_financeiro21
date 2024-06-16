package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Relatorio extends EntityId{

    @OneToMany(mappedBy = "relatorio")
    private List<Entrada> entradas;
    @OneToMany(mappedBy = "relatorio")
    private List<Solicitacao> solicitacoes;
    @Column
    private Double relDemonstrativo;
    public Relatorio() {

    }
    public Relatorio(List<Entrada> entradas, List<Solicitacao> solicitacoes, Double relDemonstrativo) {
        this.entradas = entradas;
        this.solicitacoes = solicitacoes;
        this.relDemonstrativo = relDemonstrativo;
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

    public Double getRelDemonstrativo() {
        return relDemonstrativo;
    }

    public void setRelDemonstrativo(Double relDemonstrativo) {
        this.relDemonstrativo = relDemonstrativo;
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "entradas=" + entradas +
                ", solicitacoes=" + solicitacoes +
                ", relDemonstrativo=" + relDemonstrativo +
                '}';
    }
}

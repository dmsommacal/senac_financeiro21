package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Solicitacao extends EntityId{
    @Column
    private Double solicitacao;
    @Column
    private Boolean aprovacao;
    @Column
    private String descricao;

    public Solicitacao(Double solicitacao, Boolean aprovacao, String descricao) {
        this.solicitacao = solicitacao;
        this.aprovacao = aprovacao;
        this.descricao = descricao;
    }

    public Double getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Double solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Boolean getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(Boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Solicitacao{" +
                "solicitacao=" + solicitacao +
                ", aprovacao=" + aprovacao +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

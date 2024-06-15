package rh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Solicitacao extends EntityId{
    @Column
    private Double valorSolicitado;
    @Column
    private Boolean aprovacao;
    @Column
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "saldo_id")
    @JsonIgnore
    private Saldo saldo;

    public Solicitacao() {
    }

    public Solicitacao(Double valorSolicitado, Boolean aprovacao, String descricao, Saldo saldo) {
        this.valorSolicitado = valorSolicitado;
        this.aprovacao = aprovacao;
        this.descricao = descricao;
        this.saldo = saldo;
    }

    public Double getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(Double valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
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

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Solicitacao{" +
                "valorSolicitado=" + valorSolicitado +
                ", aprovacao=" + aprovacao +
                ", descricao='" + descricao + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}

package rh.model;

import  com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Solicitacao extends EntityId{
    @ManyToOne
    @JoinColumn(name = "saldo_id")
    @JsonIgnore
    private Saldo saldo;
    @Column(nullable = false)
    private BigDecimal valorSolicitado;
    @Column
    private LocalDateTime dataHora;
    @Column
    private String descricao;

    public Solicitacao() {
    }

    public Solicitacao(Saldo saldo, BigDecimal valorSolicitado, LocalDateTime dataHora, String descricao) {
        this.saldo = saldo;
        this.valorSolicitado = valorSolicitado;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(BigDecimal valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
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
                "saldo=" + saldo +
                ", valorSolicitado=" + valorSolicitado +
                ", dataHora=" + dataHora +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}


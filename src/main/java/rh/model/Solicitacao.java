package rh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Solicitacao extends EntityId{
    @ManyToOne
    @JoinColumn(name = "saldo_id")
    @JsonIgnore
    private Saldo saldo;
    @ManyToOne
    @JoinColumn(name = "relatorio_id")
    private Relatorio relatorio;
    @Column(nullable = false)
    private BigDecimal valorSolicitado;
    @Column
    private LocalDateTime dataHora;
    @Column
    private String descricao;
    public Solicitacao() {
    }

    public Solicitacao(Saldo saldo, Relatorio relatorio, BigDecimal valorSolicitado, LocalDateTime dataHora, String descricao) {
        this.saldo = saldo;
        this.relatorio = relatorio;
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

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
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
                ", relatorio=" + relatorio +
                ", valorSolicitado=" + valorSolicitado +
                ", dataHora=" + dataHora +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}


package rh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Entrada extends EntityId{
    @ManyToOne
    @JoinColumn(name = "conta_id")
    @JsonIgnore
    private Conta conta;
    @ManyToOne
    @JoinColumn(name = "relatorio_id")
    @JsonIgnore
    private Relatorio relatorio;
    @Column(nullable = false)
    private BigDecimal valor;
    @Column
    private LocalDateTime dataHora;
    @Column
    private String descricao;

    public Entrada() {
    }

    public Entrada(Conta conta, Relatorio relatorio, BigDecimal valor, LocalDateTime dataHora, String descricao) {
        this.conta = conta;
        this.relatorio = relatorio;
        this.valor = valor;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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
        return "Entrada{" +
                "conta=" + conta +
                ", relatorio=" + relatorio +
                ", valor=" + valor +
                ", dataHora=" + dataHora +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
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
    @JoinColumn(name = "saldo_id")
    @JsonIgnore
    private Saldo saldo;
    @Column(nullable = false)
    private BigDecimal valor;
    @Column
    private LocalDateTime dataHora;
    @Column
    private String descricao;

    public Entrada() {
    }

    public Entrada(Saldo saldo, BigDecimal valor, LocalDateTime dataHora, String descricao) {
        this.saldo = saldo;
        this.valor = valor;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
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
                "saldo=" + saldo +
                ", valor=" + valor +
                ", dataHora=" + dataHora +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
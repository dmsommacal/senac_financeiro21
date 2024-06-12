package rh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Entrada extends EntityId{
        @Column(name = "valor", nullable = false)
        private Double valor;
        @Column(name = "data", nullable = false)
        private LocalDateTime data;
        @Column
        private String descricao;
        @ManyToOne
        @JoinColumn(name = "saldo_id")
        @JsonIgnore
        private Saldo saldo;
    public Entrada() {
    }

    public Entrada(Double valor, LocalDateTime data, String descricao, Saldo saldo) {
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.saldo = saldo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
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
        return "Entrada{" +
                "valor=" + valor +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}

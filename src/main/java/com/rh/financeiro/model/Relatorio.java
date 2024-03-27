package com.rh.financeiro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Relatorio extends EntityId{
    @Column
    private Double relEntrada;
    @Column
    private Double relSaida;
    @Column
    private Double relDemonstrativo;

    public Relatorio(Double relEntrada, Double relSaida, Double relDemosntrativo) {
        this.relEntrada = relEntrada;
        this.relSaida = relSaida;
        this.relDemonstrativo = relDemosntrativo;
    }

    public Double getRelEntrada() {
        return relEntrada;
    }

    public void setRelEntrada(Double relEntrada) {
        this.relEntrada = relEntrada;
    }

    public Double getRelSaida() {
        return relSaida;
    }

    public void setRelSaida(Double relSaida) {
        this.relSaida = relSaida;
    }

    public Double getRelDemosntrativo() {
        return relDemonstrativo;
    }

    public void setRelDemosntrativo(Double relDemosntrativo) {
        this.relDemonstrativo = relDemosntrativo;
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "relEntrada=" + relEntrada +
                ", relSaida=" + relSaida +
                ", relDemonstrativo=" + relDemonstrativo +
                '}';
    }
}

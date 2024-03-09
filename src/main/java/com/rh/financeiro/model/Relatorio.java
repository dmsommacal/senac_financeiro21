package com.rh.financeiro.model;

public class Relatorio {

    private Double relEntrada;
    private Double relSaida;
    private Double relDemosntrativo;

    public Relatorio(Double relEntrada, Double relSaida, Double relDemosntrativo) {
        this.relEntrada = relEntrada;
        this.relSaida = relSaida;
        this.relDemosntrativo = relDemosntrativo;
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
        return relDemosntrativo;
    }

    public void setRelDemosntrativo(Double relDemosntrativo) {
        this.relDemosntrativo = relDemosntrativo;
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "relEntrada=" + relEntrada +
                ", relSaida=" + relSaida +
                ", relDemosntrativo=" + relDemosntrativo +
                '}';
    }
}

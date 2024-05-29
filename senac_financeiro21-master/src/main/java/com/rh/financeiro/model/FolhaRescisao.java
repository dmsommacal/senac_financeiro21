package com.rh.financeiro.model;

import jakarta.persistence.Column;

public class FolhaRescisao extends FolhaPagamento{
    @Column
    private Double valorRescisao;

    public FolhaRescisao(Double hrtrabalhada, Double INSS, Double IRRF, Double FGTS, Double valorRescisao) {
        super(hrtrabalhada, INSS, IRRF, FGTS);
        this.valorRescisao = valorRescisao;
    }

    public Double getValorRescisao() {
        return valorRescisao;
    }

    public void setValorRescisao(Double valorRescisao) {
        this.valorRescisao = valorRescisao;
    }

    @Override
    public String toString() {
        return "FolhaRescisao{" +
                "valorRescisao=" + valorRescisao +
                '}';
    }
}

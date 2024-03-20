package com.example.finaceiro24.Model;

public class FolhaRescisao {
    private Double valorRescisao;

    public FolhaRescisao(Double valorRescisao) {
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

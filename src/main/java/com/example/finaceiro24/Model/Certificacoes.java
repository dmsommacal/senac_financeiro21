package com.example.finaceiro24.Model;

import java.time.LocalDate;

public class Certificacoes {
    private String Nome;
    private Double CargaHoraria;
    private LocalDate DataEmissao;

    public Certificacoes(String nome, Double cargaHoraria, LocalDate dataEmissao) {
        Nome = nome;
        CargaHoraria = cargaHoraria;
        DataEmissao = dataEmissao;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Double getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        CargaHoraria = cargaHoraria;
    }

    public LocalDate getDataEmissao() {
        return DataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        DataEmissao = dataEmissao;
    }

    @Override
    public String toString() {
        return "Certificacoes{" +
                "Nome='" + Nome + '\'' +
                ", CargaHoraria=" + CargaHoraria +
                ", DataEmissao=" + DataEmissao +
                '}';
    }
}

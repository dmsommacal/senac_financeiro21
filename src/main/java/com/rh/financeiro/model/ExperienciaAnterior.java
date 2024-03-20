package com.rh.financeiro.model;

import java.time.LocalDate;

public class ExperienciaAnterior {

    private String Descricao;
    private String Cargo;
    private LocalDate PeriodoInicial;
    private LocalDate PeriodoFinal;

    public ExperienciaAnterior(String descricao, String cargo, LocalDate periodoInicial, LocalDate periodoFinal) {
        Descricao = descricao;
        Cargo = cargo;
        PeriodoInicial = periodoInicial;
        PeriodoFinal = periodoFinal;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public LocalDate getPeriodoInicial() {
        return PeriodoInicial;
    }

    public void setPeriodoInicial(LocalDate periodoInicial) {
        PeriodoInicial = periodoInicial;
    }

    public LocalDate getPeriodoFinal() {
        return PeriodoFinal;
    }

    public void setPeriodoFinal(LocalDate periodoFinal) {
        PeriodoFinal = periodoFinal;
    }

    @Override
    public String toString() {
        return "ExperienciaAnterior{" +
                "Descricao='" + Descricao + '\'' +
                ", Cargo='" + Cargo + '\'' +
                ", PeriodoInicial=" + PeriodoInicial +
                ", PeriodoFinal=" + PeriodoFinal +
                '}';
    }
}

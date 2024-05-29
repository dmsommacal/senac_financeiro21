package com.rh.financeiro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Certificacoes extends EntityId{
    @Column
    private String Nome;
    @Column
    private Double CargaHoraria;
    @Column
    private LocalDate DataEmissao;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public Certificacoes(String nome, Double cargaHoraria, LocalDate dataEmissao, Funcionario funcionario) {
        Nome = nome;
        CargaHoraria = cargaHoraria;
        DataEmissao = dataEmissao;
        this.funcionario = funcionario;
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Certificacoes{" +
                "Nome='" + Nome + '\'' +
                ", CargaHoraria=" + CargaHoraria +
                ", DataEmissao=" + DataEmissao +
                ", funcionario=" + funcionario +
                '}';
    }
}

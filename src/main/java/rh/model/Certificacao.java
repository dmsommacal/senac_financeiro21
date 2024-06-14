package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Certificacao extends EntityId{
    @Column
    private String nome;
    @Column
    private Double cargaHoraria;
    @Column
    private LocalDate dataEmissao;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public Certificacao(String nome, Double cargaHoraria, LocalDate dataEmissao, Funcionario funcionario) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.dataEmissao = dataEmissao;
        this.funcionario = funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
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
                "nome='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", dataEmissao=" + dataEmissao +
                ", funcionario=" + funcionario +
                '}';
    }
}

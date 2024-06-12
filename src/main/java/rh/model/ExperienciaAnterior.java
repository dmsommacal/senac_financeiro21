package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class ExperienciaAnterior extends EntityId{
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    @Column
    private String descricao;
    @Column
    private String cargo;
    @Column
    private LocalDate periodoInicial;
    @Column
    private LocalDate periodoFinal;

    public ExperienciaAnterior(Funcionario funcionario, String descricao, String cargo, LocalDate periodoInicial, LocalDate periodoFinal) {
        this.funcionario = funcionario;
        this.descricao = descricao;
        this.cargo = cargo;
        this.periodoInicial = periodoInicial;
        this.periodoFinal = periodoFinal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getPeriodoInicial() {
        return periodoInicial;
    }

    public void setPeriodoInicial(LocalDate periodoInicial) {
        this.periodoInicial = periodoInicial;
    }

    public LocalDate getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(LocalDate periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    @Override
    public String toString() {
        return "ExperienciaAnterior{" +
                "funcionario=" + funcionario +
                ", descricao='" + descricao + '\'' +
                ", cargo='" + cargo + '\'' +
                ", periodoInicial=" + periodoInicial +
                ", periodoFinal=" + periodoFinal +
                '}';
    }
}

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
    private String Descricao;
    @Column
    private String Cargo;
    @Column
    private LocalDate PeriodoInicial;
    @Column
    private LocalDate PeriodoFinal;

    public ExperienciaAnterior(Funcionario funcionario, String descricao, String cargo, LocalDate periodoInicial, LocalDate periodoFinal) {
        this.funcionario = funcionario;
        Descricao = descricao;
        Cargo = cargo;
        PeriodoInicial = periodoInicial;
        PeriodoFinal = periodoFinal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
                "funcionario=" + funcionario +
                ", Descricao='" + Descricao + '\'' +
                ", Cargo='" + Cargo + '\'' +
                ", PeriodoInicial=" + PeriodoInicial +
                ", PeriodoFinal=" + PeriodoFinal +
                '}';
    }
}

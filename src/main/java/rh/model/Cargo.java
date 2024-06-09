package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import rh.enums.ModalidadeContratual;
import rh.enums.Turno;

import java.util.List;

@Entity
public class Cargo extends EntityId{
    @OneToMany
    private List<Funcionario> funcionarios;
    @Column
    private String Descricao;
    @Column
    private String Nivel;
    @Column
    private Boolean Comissao;
    private Turno turno;
    private ModalidadeContratual modalidadeContratual;

    public Cargo(List<Funcionario> funcionarios, String descricao, String nivel, Boolean comissao, Turno turno, ModalidadeContratual modalidadeContratual) {
        this.funcionarios = funcionarios;
        Descricao = descricao;
        Nivel = nivel;
        Comissao = comissao;
        this.turno = turno;
        this.modalidadeContratual = modalidadeContratual;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String nivel) {
        Nivel = nivel;
    }

    public Boolean getComissao() {
        return Comissao;
    }

    public void setComissao(Boolean comissao) {
        Comissao = comissao;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public ModalidadeContratual getModalidadeContratual() {
        return modalidadeContratual;
    }

    public void setModalidadeContratual(ModalidadeContratual modalidadeContratual) {
        this.modalidadeContratual = modalidadeContratual;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "funcionarios=" + funcionarios +
                ", Descricao='" + Descricao + '\'' +
                ", Nivel='" + Nivel + '\'' +
                ", Comissao=" + Comissao +
                ", turno=" + turno +
                ", modalidadeContratual=" + modalidadeContratual +
                '}';
    }
}

package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import rh.enums.ModalidadeContratual;
import rh.enums.Turno;

import java.util.List;

@Entity
public class Cargo extends EntityId{
    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;
    @Column
    private String descricao;
    @Column
    private String nivel;
    @Column
    private Boolean comissao;
    private Turno turno;
    private ModalidadeContratual modalidadeContratual;

    public Cargo(List<Funcionario> funcionarios, String descricao, String nivel, Boolean comissao, Turno turno, ModalidadeContratual modalidadeContratual) {
        this.funcionarios = funcionarios;
        this.descricao = descricao;
        this.nivel = nivel;
        this.comissao = comissao;
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
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Boolean getComissao() {
        return comissao;
    }

    public void setComissao(Boolean comissao) {
        this.comissao = comissao;
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
                ", descricao='" + descricao + '\'' +
                ", nivel='" + nivel + '\'' +
                ", comissao=" + comissao +
                ", turno=" + turno +
                ", modalidadeContratual=" + modalidadeContratual +
                '}';
    }
}

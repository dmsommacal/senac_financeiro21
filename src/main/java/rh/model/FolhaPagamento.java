package rh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class FolhaPagamento extends EntityId{
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;
    @Column(nullable = true)
    private BigDecimal inss = BigDecimal.ZERO;
    @Column(nullable = true)
    private BigDecimal irrf = BigDecimal.ZERO;
    @Column(nullable = true)
    private BigDecimal baseIrrf = BigDecimal.ZERO;
    @Column(nullable = true)
    private BigDecimal salarioLiquido = BigDecimal.ZERO;

    public FolhaPagamento() {
    }

    public FolhaPagamento(Funcionario funcionario, BigDecimal inss, BigDecimal irrf, BigDecimal baseIrrf, BigDecimal salarioLiquido) {
        this.funcionario = funcionario;
        this.inss = inss;
        this.irrf = irrf;
        this.baseIrrf = baseIrrf;
        this.salarioLiquido = salarioLiquido;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public BigDecimal getInss() {
        return inss;
    }

    public void setInss(BigDecimal inss) {
        this.inss = inss;
    }

    public BigDecimal getIrrf() {
        return irrf;
    }

    public void setIrrf(BigDecimal irrf) {
        this.irrf = irrf;
    }

    public BigDecimal getBaseIrrf() {
        return baseIrrf;
    }

    public void setBaseIrrf(BigDecimal baseIrrf) {
        this.baseIrrf = baseIrrf;
    }

    public BigDecimal getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(BigDecimal salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    @Override
    public String toString() {
        return "FolhaPagamento{" +
                "funcionario=" + funcionario +
                ", inss=" + inss +
                ", irrf=" + irrf +
                ", baseIrrf=" + baseIrrf +
                ", salarioLiquido=" + salarioLiquido +
                '}';
    }
}
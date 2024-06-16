package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class FolhaPagamento extends EntityId{
    @Column
    private Double horaTrabalhada;
    @Column
    private Double inss;
    @Column
    private Double irrf;
    @Column
    private Double fgts;

    public FolhaPagamento() {
        this.horaTrabalhada = horaTrabalhada;
        this.inss = inss;
        this.irrf = irrf;
        this.fgts = fgts;
    }

    public Double getHoraTrabalhada() {
        return horaTrabalhada;
    }

    public void setHoraTrabalhada(Double horaTrabalhada) {
        this.horaTrabalhada = horaTrabalhada;
    }

    public Double getInss() {
        return inss;
    }

    public void setInss(Double inss) {
        this.inss = inss;
    }

    public Double getIrrf() {
        return irrf;
    }

    public void setIrrf(Double irrf) {
        this.irrf = irrf;
    }

    public Double getFgts() {
        return fgts;
    }

    public void setFgts(Double fgts) {
        this.fgts = fgts;
    }

    @Override
    public String toString() {
        return "FolhaPagamento{" +
                "horaTrabalhada=" + horaTrabalhada +
                ", inss=" + inss +
                ", irrf=" + irrf +
                ", fgts=" + fgts +
                '}';
    }
}
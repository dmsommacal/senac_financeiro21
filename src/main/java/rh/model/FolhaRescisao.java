package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class FolhaRescisao extends FolhaPagamento{
    @Column
    private Double valorRescisao;

    public FolhaRescisao() {
        super();
        this.valorRescisao = valorRescisao;
    }

    public Double getValorRescisao() {
        return valorRescisao;
    }

    public void setValorRescisao(Double valorRescisao) {
        this.valorRescisao = valorRescisao;
    }

    @Override
    public String toString() {
        return "FolhaRescisao{" +
                "valorRescisao=" + valorRescisao +
                '}';
    }
}

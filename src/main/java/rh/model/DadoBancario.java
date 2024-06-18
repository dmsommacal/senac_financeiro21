package rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import rh.enums.TipoConta;

import java.util.List;

@Entity
public class DadoBancario extends EntityId{
    @Column
    private String banco;
    @Column
    private String agencia;
    @Column
    private String conta;
    private List<TipoConta> tipoConta;

    public DadoBancario() {
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.tipoConta = tipoConta;
    }
    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public List<TipoConta> getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(List<TipoConta> tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public String toString() {
        return "DadosBancarios{" +
                "banco='" + banco + '\'' +
                ", agencia='" + agencia + '\'' +
                ", conta='" + conta + '\'' +
                ", tipoConta=" + tipoConta +
                '}';
    }
}

package com.rh.financeiro.model;

import java.util.List;

public class DadosBancarios {

    private String Banco;
    private String Agencia;
    private String Conta;
    private List<TipoConta> tipoConta;

    public DadosBancarios(String banco, String agencia, String conta, List<TipoConta> tipoConta) {
        Banco = banco;
        Agencia = agencia;
        Conta = conta;
        this.tipoConta = tipoConta;
    }

    public String getBanco() {
        return Banco;
    }

    public void setBanco(String banco) {
        Banco = banco;
    }

    public String getAgencia() {
        return Agencia;
    }

    public void setAgencia(String agencia) {
        Agencia = agencia;
    }

    public String getConta() {
        return Conta;
    }

    public void setConta(String conta) {
        Conta = conta;
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
                "Banco='" + Banco + '\'' +
                ", Agencia='" + Agencia + '\'' +
                ", Conta='" + Conta + '\'' +
                ", tipoConta=" + tipoConta +
                '}';
    }
}

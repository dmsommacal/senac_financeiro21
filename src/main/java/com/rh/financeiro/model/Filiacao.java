package com.rh.financeiro.model;

public class Filiacao {

    private String NomePai;
    private String TelefonePai;
    private String NomeMae;
    private String TelefoneMae;

    public Filiacao(String nomePai, String telefonePai, String nomeMae, String telefoneMae) {
        NomePai = nomePai;
        TelefonePai = telefonePai;
        NomeMae = nomeMae;
        TelefoneMae = telefoneMae;
    }

    public String getNomePai() {
        return NomePai;
    }

    public void setNomePai(String nomePai) {
        NomePai = nomePai;
    }

    public String getTelefonePai() {
        return TelefonePai;
    }

    public void setTelefonePai(String telefonePai) {
        TelefonePai = telefonePai;
    }

    public String getNomeMae() {
        return NomeMae;
    }

    public void setNomeMae(String nomeMae) {
        NomeMae = nomeMae;
    }

    public String getTelefoneMae() {
        return TelefoneMae;
    }

    public void setTelefoneMae(String telefoneMae) {
        TelefoneMae = telefoneMae;
    }
    @Override
    public String toString() {
        return "Filiacao{" +
                "NomePai='" + NomePai + '\'' +
                ", TelefonePai='" + TelefonePai + '\'' +
                ", NomeMae='" + NomeMae + '\'' +
                ", TelefoneMae='" + TelefoneMae + '\'' +
                '}';
    }
}

package rh.resource.dto;


import rh.enums.TipoConta;
import rh.model.DadoBancario;

import java.util.ArrayList;
import java.util.List;

public class DadoBancarioDTO {

    private String banco;

    private String agencia;

    private String conta;
    private List<TipoConta> tipoConta;

    public DadoBancarioDTO() {
    }

    public DadoBancarioDTO(String banco, String agencia, String conta, List<TipoConta> tipoConta) {
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

    public static DadoBancarioDTO fromEntity(DadoBancario dadoBancario) {
        return new DadoBancarioDTO(
                dadoBancario.getBanco(),
                dadoBancario.getAgencia(),
                dadoBancario.getConta(),
                dadoBancario.getTipoConta()
        );
    }
    public static List<DadoBancarioDTO> fromEntityList(List<DadoBancario> dadoBancarios){
        List<DadoBancarioDTO> dadoBancarioDTOList = new ArrayList<>();
        for (DadoBancario dadoBancario : dadoBancarios){
            dadoBancarioDTOList.add(fromEntity(dadoBancario));
        }
        return dadoBancarioDTOList;
    }
    public DadoBancario toEntity() {
        DadoBancario dadoBancario = new DadoBancario();
        dadoBancario.setBanco(this.banco);
        dadoBancario.setAgencia(this.agencia);
        dadoBancario.setConta(this.conta);
        dadoBancario.setTipoConta(this.tipoConta);
        return dadoBancario;
    }
    public static List<DadoBancario> toEntityList(List<DadoBancarioDTO> dadoBancarioDTOS){
        List<DadoBancario> dadoBancarios = new ArrayList<>();
        for (DadoBancarioDTO dadoBancarioDTO : dadoBancarioDTOS){
            dadoBancarios.add(dadoBancarioDTO.toEntity());
        }
        return dadoBancarios;
    }
}

package rh.resource.dto;


import rh.model.Cargo;
import rh.model.Saldo;
import rh.model.Solicitacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoDTO {
    private Saldo saldo;
    private BigDecimal valorSolicitado;

    private LocalDateTime dataHora;

    private String descricao;

    public SolicitacaoDTO() {
    }

    public SolicitacaoDTO(Saldo saldo, BigDecimal valorSolicitado, LocalDateTime dataHora, String descricao) {
        this.saldo = saldo;
        this.valorSolicitado = valorSolicitado;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(BigDecimal valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public static SolicitacaoDTO fromEntity(Solicitacao solicitacao) {
        return new SolicitacaoDTO(
                solicitacao.getSaldo(),
                solicitacao.getValorSolicitado(),
                solicitacao.getDataHora(),
                solicitacao.getDescricao()
        );
    }
    public static List<SolicitacaoDTO> fromEntityList(List<Solicitacao> solicitacaos) {
        List<SolicitacaoDTO> solicitacaoDTOList = new ArrayList<>();
        for (Solicitacao solicitacao : solicitacaos) {
            solicitacaoDTOList.add(fromEntity(solicitacao));
        }
        return solicitacaoDTOList;
    }
    public Solicitacao toEntity() {
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setSaldo(this.saldo);
        solicitacao.setValorSolicitado(this.valorSolicitado);
        solicitacao.setDataHora(this.dataHora);
        solicitacao.setDescricao(this.descricao);
        return solicitacao;
    }
    public static List<Solicitacao> toEntityList(List<SolicitacaoDTO> solicitacaoDTOS){
        List<Solicitacao> solicitacaos = new ArrayList<>();
        for (SolicitacaoDTO solicitacaoDTO : solicitacaoDTOS){
            solicitacaos.add(solicitacaoDTO.toEntity());
        }
        return solicitacaos;
    }
}

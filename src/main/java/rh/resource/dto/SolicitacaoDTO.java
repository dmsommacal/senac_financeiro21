package rh.resource.dto;


import rh.model.Relatorio;
import rh.model.Conta;
import rh.model.Solicitacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoDTO {
    private Long id;
    private Conta conta;
    private Relatorio relatorio;
    private BigDecimal valorSolicitado;
    private LocalDateTime dataHora;
    private String descricao;
    public SolicitacaoDTO() {
    }

    public SolicitacaoDTO(Long id, Conta conta, Relatorio relatorio, BigDecimal valorSolicitado, LocalDateTime dataHora, String descricao) {
        this.id = id;
        this.conta = conta;
        this.relatorio = relatorio;
        this.valorSolicitado = valorSolicitado;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Conta getSaldo() {
        return conta;
    }

    public void setSaldo(Conta conta) {
        this.conta = conta;
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
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
                solicitacao.getId(),
                solicitacao.getConta(),
                solicitacao.getRelatorio(),
                solicitacao.getValorSolicitado(),
                solicitacao.getDataHora(),
                solicitacao.getDescricao()
        );
    }
    public static List<SolicitacaoDTO> fromEntityList(List<Solicitacao> solicitacoes) {
        List<SolicitacaoDTO> solicitacaoDTOList = new ArrayList<>();
        for (Solicitacao solicitacao : solicitacoes) {
            solicitacaoDTOList.add(fromEntity(solicitacao));
        }
        return solicitacaoDTOList;
    }
    public Solicitacao toEntity() {
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setId(this.id);
        solicitacao.setConta(this.conta);
        solicitacao.setRelatorio(this.relatorio);
        solicitacao.setValorSolicitado(this.valorSolicitado);
        solicitacao.setDataHora(this.dataHora);
        solicitacao.setDescricao(this.descricao);
        return solicitacao;
    }
    public static List<Solicitacao> toEntityList(List<SolicitacaoDTO> solicitacaoDTOS){
        List<Solicitacao> solicitacoes = new ArrayList<>();
        for (SolicitacaoDTO solicitacaoDTO : solicitacaoDTOS){
            solicitacoes.add(solicitacaoDTO.toEntity());
        }
        return solicitacoes;
    }
}

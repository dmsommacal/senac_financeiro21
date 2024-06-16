package rh.resource.dto;


import rh.model.Cargo;
import rh.model.Certificacao;
import rh.model.Funcionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CertificacaoDTO {
    private String nome;

    private Double cargaHoraria;

    private LocalDate dataEmissao;

    private Funcionario funcionario;

    public CertificacaoDTO() {
    }

    public CertificacaoDTO(String nome, Double cargaHoraria, LocalDate dataEmissao, Funcionario funcionario) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.dataEmissao = dataEmissao;
        this.funcionario = funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public static CertificacaoDTO fromEntity(Certificacao certificacao) {
        return new CertificacaoDTO(
                certificacao.getNome(),
                certificacao.getCargaHoraria(),
                certificacao.getDataEmissao(),
                certificacao.getFuncionario()
        );
    }
    public static List<CertificacaoDTO> fromEntityList(List<Certificacao> certificacaos){
        List<CertificacaoDTO> certificacaoDTOList = new ArrayList<>();
        for (Certificacao certificacao : certificacaos){
            certificacaoDTOList.add(fromEntity(certificacao));
        }
        return certificacaoDTOList;
    }
    public Certificacao toEntity() {
        Certificacao certificacao = new Certificacao();
        certificacao.setNome(this.nome);
        certificacao.setCargaHoraria(this.cargaHoraria);
        certificacao.setDataEmissao(this.dataEmissao);
        certificacao.setFuncionario(this.funcionario);
        return certificacao;
    }
    public static List<Certificacao> toEntityList(List<CertificacaoDTO> certificacaoDTOS){
        List<Certificacao> certificacaos = new ArrayList<>();
        for (CertificacaoDTO certificacaoDTO : certificacaoDTOS){
            certificacaos.add(certificacaoDTO.toEntity());
        }
        return certificacaos;
    }
}

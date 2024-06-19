package rh.resource.dto;

import rh.model.Entrada;
import rh.model.Relatorio;
import rh.model.Conta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EntradaDTO {
    private Conta conta;
    private Relatorio relatorio;
    private BigDecimal valor;
    private LocalDateTime dataHora;
    private String descricao;

    public EntradaDTO() {
    }

    public EntradaDTO(Conta conta, Relatorio relatorio, BigDecimal valor, LocalDateTime dataHora, String descricao) {
        this.conta = conta;
        this.relatorio = relatorio;
        this.valor = valor;
        this.dataHora = dataHora;
        this.descricao = descricao;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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

    public static EntradaDTO fromEntity(Entrada entrada) {
        return new EntradaDTO(
                entrada.getConta(),
                entrada.getRelatorio(),
                entrada.getValor(),
                entrada.getDataHora(),
                entrada.getDescricao()
        );
    }

    public static List<EntradaDTO> fromEntityList(List<Entrada> entradas){
        List<EntradaDTO> entradaDTOList = new ArrayList<>();
        for (Entrada entrada : entradas){
            entradaDTOList.add(fromEntity(entrada));
        }
        return entradaDTOList;
    }

    public Entrada toEntity() {
        Entrada entrada = new Entrada();
        entrada.setValor(this.valor);
        entrada.setRelatorio(this.relatorio);
        entrada.setConta(this.conta);
        entrada.setDataHora(this.dataHora);
        entrada.setDescricao(this.descricao);
        return entrada;
    }

    public static List<Entrada> toEntityList(List<EntradaDTO> entradaDTOS){
        List<Entrada> entradas = new ArrayList<>();
        for (EntradaDTO entradaDTO : entradaDTOS){
            entradas.add(entradaDTO.toEntity());
        }
        return entradas;
    }
}

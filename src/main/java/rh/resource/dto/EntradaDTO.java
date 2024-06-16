package rh.resource.dto;

import jakarta.persistence.Column;
import rh.model.Cargo;
import rh.model.Entrada;
import rh.model.Saldo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EntradaDTO {
    private Saldo saldo;
    private BigDecimal valor;

    private LocalDateTime dataHora;
    private String descricao;

    public EntradaDTO() {
    }

    public EntradaDTO(Saldo saldo, BigDecimal valor, LocalDateTime dataHora, String descricao) {
        this.saldo = saldo;
        this.valor = valor;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
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
                entrada.getSaldo(),
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
        entrada.setSaldo(this.saldo);
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

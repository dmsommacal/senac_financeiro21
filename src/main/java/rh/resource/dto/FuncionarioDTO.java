package rh.resource.dto;

import rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDTO {
    private Long id;
    private String cargo;
    private String nome;
    private String cpf;
    private String rg;
    private BigDecimal salarioContratual;
    private String fonePessoal;
    private String foneRecados;
    private LocalDate dataNascimento;
    private String email;
    public FuncionarioDTO() {
    }
    public FuncionarioDTO(Long id, String cargo, String nome, String cpf, String rg, BigDecimal salarioContratual, String fonePessoal, String foneRecados, LocalDate dataNascimento, String email) {
        this.id = id;
        this.cargo = cargo;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.salarioContratual = salarioContratual;
        this.fonePessoal = fonePessoal;
        this.foneRecados = foneRecados;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public BigDecimal getSalarioContratual() {
        return salarioContratual;
    }

    public void setSalarioContratual(BigDecimal salarioContratual) {
        this.salarioContratual = salarioContratual;
    }

    public String getFonePessoal() {
        return fonePessoal;
    }

    public void setFonePessoal(String fonePessoal) {
        this.fonePessoal = fonePessoal;
    }

    public String getFoneRecados() {
        return foneRecados;
    }

    public void setFoneRecados(String foneRecados) {
        this.foneRecados = foneRecados;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static FuncionarioDTO fromEntity(Funcionario funcionario) {
        return new FuncionarioDTO(
                funcionario.getId(),
                funcionario.getCargo(),
                funcionario.getNome(),
                funcionario.getCpf(),
                funcionario.getRg(),
                funcionario.getSalarioContratual(),
                funcionario.getFonePessoal(),
                funcionario.getFoneRecados(),
                funcionario.getDataNascimento(),
                funcionario.getEmail()
        );
    }
    public static List<FuncionarioDTO> fromEntityList(List<Funcionario> funcionarios){
        List<FuncionarioDTO> FuncionarioDTOList = new ArrayList<>();
        for (Funcionario funcionario : funcionarios){
            FuncionarioDTOList.add(fromEntity(funcionario));
        }
        return FuncionarioDTOList;
    }
    public Funcionario toEntity() {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(this.id);
        funcionario.setCargo(this.cargo);
        funcionario.setNome(this.nome);
        funcionario.setCpf(this.cpf);
        funcionario.setRg(this.rg);
        funcionario.setSalarioContratual(this.salarioContratual);
        funcionario.setFonePessoal(this.fonePessoal);
        funcionario.setFoneRecados(this.foneRecados);
        funcionario.setDataNascimento(this.dataNascimento);
        funcionario.setEmail(this.email);
        return funcionario;
    }
    public static List<Funcionario> toEntityList(List<FuncionarioDTO> funcionarioDTOs){
        List<Funcionario> funcionarios = new ArrayList<>();
        for (FuncionarioDTO funcionarioDTO : funcionarioDTOs){
            funcionarios.add(funcionarioDTO.toEntity());
        }
        return funcionarios;
    }
}

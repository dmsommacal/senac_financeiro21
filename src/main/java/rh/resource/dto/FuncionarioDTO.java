package rh.resource.dto;

import rh.enums.Escolaridade;
import rh.enums.EstadoCivil;
import rh.enums.Genero;
import rh.enums.Status;
import rh.model.Cargo;
import rh.model.Certificacao;
import rh.model.ExperienciaAnterior;
import rh.model.Funcionario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDTO {
    private List<ExperienciaAnterior> experienciasAnteriores;
    private List<Certificacao> certificacoes;
    private Escolaridade escolaridade;
    private EstadoCivil estadoCivil;
    private Genero genero;
    private Status status;
    private Cargo cargo;
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String ctps;
    private Double salarioContratual;
    private Integer cargaHoraria;
    private String fonePessoal;
    private String foneRecados;
    private String titulo;
    private String carteiraReservista;
    private LocalDate dataNascimento;
    private String pis;
    private String registroProfissional;
    private String email;
    private String sindicato;
    private String setor;
    private String cnh;
    private LocalDate dataAdmissao;
    private String racaCor;
    private String religiao;
    private Boolean doadorSangue;
    private String nacionalidade;
    private String redeSocial;
    private String areaAtuacao;
    private String matricula;
    private String idiomas;
    private Integer horaExtra;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(List<ExperienciaAnterior> experienciasAnteriores, List<Certificacao> certificacoes, Escolaridade escolaridade, EstadoCivil estadoCivil, Genero genero, Status status, Cargo cargo, String nome, String cpf, String rg, String endereco, String ctps, Double salarioContratual, Integer cargaHoraria, String fonePessoal, String foneRecados, String titulo, String carteiraReservista, LocalDate dataNascimento, String pis, String registroProfissional, String email, String sindicato, String setor, String cnh, LocalDate dataAdmissao, String racaCor, String religiao, Boolean doadorSangue, String nacionalidade, String redeSocial, String areaAtuacao, String matricula, String idiomas, Integer horaExtra, LocalTime horaEntrada, LocalTime horaSaida) {
        this.experienciasAnteriores = experienciasAnteriores;
        this.certificacoes = certificacoes;
        this.escolaridade = escolaridade;
        this.estadoCivil = estadoCivil;
        this.genero = genero;
        this.status = status;
        this.cargo = cargo;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.ctps = ctps;
        this.salarioContratual = salarioContratual;
        this.cargaHoraria = cargaHoraria;
        this.fonePessoal = fonePessoal;
        this.foneRecados = foneRecados;
        this.titulo = titulo;
        this.carteiraReservista = carteiraReservista;
        this.dataNascimento = dataNascimento;
        this.pis = pis;
        this.registroProfissional = registroProfissional;
        this.email = email;
        this.sindicato = sindicato;
        this.setor = setor;
        this.cnh = cnh;
        this.dataAdmissao = dataAdmissao;
        this.racaCor = racaCor;
        this.religiao = religiao;
        this.doadorSangue = doadorSangue;
        this.nacionalidade = nacionalidade;
        this.redeSocial = redeSocial;
        this.areaAtuacao = areaAtuacao;
        this.matricula = matricula;
        this.idiomas = idiomas;
        this.horaExtra = horaExtra;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public List<ExperienciaAnterior> getExperienciasAnteriores() {
        return experienciasAnteriores;
    }

    public void setExperienciasAnteriores(List<ExperienciaAnterior> experienciasAnteriores) {
        this.experienciasAnteriores = experienciasAnteriores;
    }

    public List<Certificacao> getCertificacoes() {
        return certificacoes;
    }

    public void setCertificacoes(List<Certificacao> certificacoes) {
        this.certificacoes = certificacoes;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public Double getSalarioContratual() {
        return salarioContratual;
    }

    public void setSalarioContratual(Double salarioContratual) {
        this.salarioContratual = salarioContratual;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCarteiraReservista() {
        return carteiraReservista;
    }

    public void setCarteiraReservista(String carteiraReservista) {
        this.carteiraReservista = carteiraReservista;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSindicato() {
        return sindicato;
    }

    public void setSindicato(String sindicato) {
        this.sindicato = sindicato;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getRacaCor() {
        return racaCor;
    }

    public void setRacaCor(String racaCor) {
        this.racaCor = racaCor;
    }

    public String getReligiao() {
        return religiao;
    }

    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    public Boolean getDoadorSangue() {
        return doadorSangue;
    }

    public void setDoadorSangue(Boolean doadorSangue) {
        this.doadorSangue = doadorSangue;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getHoraExtra() {
        return horaExtra;
    }

    public void setHoraExtra(Integer horaExtra) {
        this.horaExtra = horaExtra;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }
    public static FuncionarioDTO fromEntity(Funcionario funcionario) {
        return new FuncionarioDTO(
                funcionario.getExperienciasAnteriores(),
                funcionario.getCertificacoes(),
                funcionario.getEscolaridade(),
                funcionario.getEstadoCivil(),
                funcionario.getGenero(),
                funcionario.getStatus(),
                funcionario.getCargo(),
                funcionario.getNome(),
                funcionario.getCpf(),
                funcionario.getRg(),
                funcionario.getEndereco(),
                funcionario.getCtps(),
                funcionario.getSalarioContratual(),
                funcionario.getCargaHoraria(),
                funcionario.getFonePessoal(),
                funcionario.getFoneRecados(),
                funcionario.getTitulo(),
                funcionario.getCarteiraReservista(),
                funcionario.getDataNascimento(),
                funcionario.getPis(),
                funcionario.getRegistroProfissional(),
                funcionario.getEmail(),
                funcionario.getSindicato(),
                funcionario.getSetor(),
                funcionario.getCnh(),
                funcionario.getDataAdmissao(),
                funcionario.getRacaCor(),
                funcionario.getReligiao(),
                funcionario.getDoadorSangue(),
                funcionario.getNacionalidade(),
                funcionario.getRedeSocial(),
                funcionario.getAreaAtuacao(),
                funcionario.getMatricula(),
                funcionario.getIdiomas(),
                funcionario.getHoraExtra(),
                funcionario.getHoraEntrada(),
                funcionario.getHoraSaida()
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
        funcionario.setCertificacoes(this.certificacoes);
        funcionario.setEscolaridade(this.escolaridade);
        funcionario.setEstadoCivil(this.estadoCivil);
        funcionario.setGenero(this.genero);
        funcionario.setStatus(this.status);
        funcionario.setCargo(this.cargo);
        funcionario.setNome(this.nome);
        funcionario.setCpf(this.nome);
        funcionario.setRg(this.rg);
        funcionario.setEndereco(this.endereco);
        funcionario.setCtps(this.ctps);
        funcionario.setSalarioContratual(this.salarioContratual);
        funcionario.setCargaHoraria(this.cargaHoraria);
        funcionario.setFonePessoal(this.fonePessoal);
        funcionario.setFoneRecados(this.foneRecados);
        funcionario.setTitulo(this.titulo);
        funcionario.setCarteiraReservista(this.carteiraReservista);
        funcionario.setDataNascimento(this.dataNascimento);
        funcionario.setPis(this.pis);
        funcionario.setRegistroProfissional(this.registroProfissional);
        funcionario.setEmail(this.email);
        funcionario.setSindicato(this.sindicato);
        funcionario.setSetor(this.setor);
        funcionario.setCnh(this.cnh);
        funcionario.setDataAdmissao(this.dataAdmissao);
        funcionario.setRacaCor(this.racaCor);
        funcionario.setReligiao(this.religiao);
        funcionario.setDoadorSangue(this.doadorSangue);
        funcionario.setNacionalidade(this.nacionalidade);
        funcionario.setRedeSocial(this.redeSocial);
        funcionario.setAreaAtuacao(this.areaAtuacao);
        funcionario.setMatricula(this.matricula);
        funcionario.setIdiomas(this.idiomas);
        funcionario.setHoraExtra(this.horaExtra);
        funcionario.setHoraEntrada(this.horaEntrada);
        funcionario.setHoraSaida(this.horaSaida);
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

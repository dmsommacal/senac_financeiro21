package com.rh.financeiro.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Entity
public class Funcionario {
    private List<ExperienciaAnterior> ExperienciaAnterior;
    private List<Certificacoes> Certificacoes;
    private Escolaridade escolaridade;
    private EstadoCivil estadoCivil;
    private Genero genero;
    private Status status;
    private Cargo cargo;
    private String Nome;
    private String CPF;
    private String RG;
    private String Endereco;
    private String CTPS;
    private Double SalarioContratual;
    private Integer CargaHoraria;
    private String FonePessoal;
    private String FoneRecados;
    private String Titulo;
    private String CarteiraDeReservista;
    private LocalDate DataNascimento;
    private String Pis;
    private String RegistroProfissional;
    private String Email;
    private String Sindicato;
    private String Setor;
    private String CNH;
    private LocalDate DataAdmissao;
    private String RacaCor;
    private String Religiao;
    private Boolean DoadorSangue;
    private String Nacionalidade;
    private String RedeSocial;
    private String AreaAtuacao;
    private String Matricula;
    private String Idiomas;
    private Integer HoraExtra;
    private LocalTime HoraEntrada;
    private LocalTime HoraSaida;

    public Funcionario(List<com.rh.financeiro.model.ExperienciaAnterior> experienciaAnterior, List<com.rh.financeiro.model.Certificacoes> certificacoes, Escolaridade escolaridade, EstadoCivil estadoCivil, Genero genero, Status status, Cargo cargo, String nome, String CPF, String RG, String endereco, String CTPS, Double salarioContratual, Integer cargaHoraria, String fonePessoal, String foneRecados, String titulo, String carteiraDeReservista, LocalDate dataNascimento, String pis, String registroProfissional, String email, String sindicato, String setor, String CNH, LocalDate dataAdmissao, String racaCor, String religiao, Boolean doadorSangue, String nacionalidade, String redeSocial, String areaAtuacao, String matricula, String idiomas, Integer horaExtra, LocalTime horaEntrada, LocalTime horaSaida) {
        ExperienciaAnterior = experienciaAnterior;
        Certificacoes = certificacoes;
        this.escolaridade = escolaridade;
        this.estadoCivil = estadoCivil;
        this.genero = genero;
        this.status = status;
        this.cargo = cargo;
        Nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        Endereco = endereco;
        this.CTPS = CTPS;
        SalarioContratual = salarioContratual;
        CargaHoraria = cargaHoraria;
        FonePessoal = fonePessoal;
        FoneRecados = foneRecados;
        Titulo = titulo;
        CarteiraDeReservista = carteiraDeReservista;
        DataNascimento = dataNascimento;
        Pis = pis;
        RegistroProfissional = registroProfissional;
        Email = email;
        Sindicato = sindicato;
        Setor = setor;
        this.CNH = CNH;
        DataAdmissao = dataAdmissao;
        RacaCor = racaCor;
        Religiao = religiao;
        DoadorSangue = doadorSangue;
        Nacionalidade = nacionalidade;
        RedeSocial = redeSocial;
        AreaAtuacao = areaAtuacao;
        Matricula = matricula;
        Idiomas = idiomas;
        HoraExtra = horaExtra;
        HoraEntrada = horaEntrada;
        HoraSaida = horaSaida;
    }

    public List<com.rh.financeiro.model.ExperienciaAnterior> getExperienciaAnterior() {
        return ExperienciaAnterior;
    }

    public void setExperienciaAnterior(List<com.rh.financeiro.model.ExperienciaAnterior> experienciaAnterior) {
        ExperienciaAnterior = experienciaAnterior;
    }

    public List<com.rh.financeiro.model.Certificacoes> getCertificacoes() {
        return Certificacoes;
    }

    public void setCertificacoes(List<com.rh.financeiro.model.Certificacoes> certificacoes) {
        Certificacoes = certificacoes;
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
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getCTPS() {
        return CTPS;
    }

    public void setCTPS(String CTPS) {
        this.CTPS = CTPS;
    }

    public Double getSalarioContratual() {
        return SalarioContratual;
    }

    public void setSalarioContratual(Double salarioContratual) {
        SalarioContratual = salarioContratual;
    }

    public Integer getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        CargaHoraria = cargaHoraria;
    }

    public String getFonePessoal() {
        return FonePessoal;
    }

    public void setFonePessoal(String fonePessoal) {
        FonePessoal = fonePessoal;
    }

    public String getFoneRecados() {
        return FoneRecados;
    }

    public void setFoneRecados(String foneRecados) {
        FoneRecados = foneRecados;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getCarteiraDeReservista() {
        return CarteiraDeReservista;
    }

    public void setCarteiraDeReservista(String carteiraDeReservista) {
        CarteiraDeReservista = carteiraDeReservista;
    }

    public LocalDate getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public String getPis() {
        return Pis;
    }

    public void setPis(String pis) {
        Pis = pis;
    }

    public String getRegistroProfissional() {
        return RegistroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        RegistroProfissional = registroProfissional;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSindicato() {
        return Sindicato;
    }

    public void setSindicato(String sindicato) {
        Sindicato = sindicato;
    }

    public String getSetor() {
        return Setor;
    }

    public void setSetor(String setor) {
        Setor = setor;
    }

    public String getCNH() {
        return CNH;
    }

    public void setCNH(String CNH) {
        this.CNH = CNH;
    }

    public LocalDate getDataAdmissao() {
        return DataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        DataAdmissao = dataAdmissao;
    }

    public String getRacaCor() {
        return RacaCor;
    }

    public void setRacaCor(String racaCor) {
        RacaCor = racaCor;
    }

    public String getReligiao() {
        return Religiao;
    }

    public void setReligiao(String religiao) {
        Religiao = religiao;
    }

    public Boolean getDoadorSangue() {
        return DoadorSangue;
    }

    public void setDoadorSangue(Boolean doadorSangue) {
        DoadorSangue = doadorSangue;
    }

    public String getNacionalidade() {
        return Nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        Nacionalidade = nacionalidade;
    }

    public String getRedeSocial() {
        return RedeSocial;
    }

    public void setRedeSocial(String redeSocial) {
        RedeSocial = redeSocial;
    }

    public String getAreaAtuacao() {
        return AreaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        AreaAtuacao = areaAtuacao;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public String getIdiomas() {
        return Idiomas;
    }

    public void setIdiomas(String idiomas) {
        Idiomas = idiomas;
    }

    public Integer getHoraExtra() {
        return HoraExtra;
    }

    public void setHoraExtra(Integer horaExtra) {
        HoraExtra = horaExtra;
    }

    public LocalTime getHoraEntrada() {
        return HoraEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        HoraEntrada = horaEntrada;
    }

    public LocalTime getHoraSaida() {
        return HoraSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        HoraSaida = horaSaida;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "ExperienciaAnterior=" + ExperienciaAnterior +
                ", Certificacoes=" + Certificacoes +
                ", escolaridade=" + escolaridade +
                ", estadoCivil=" + estadoCivil +
                ", genero=" + genero +
                ", status=" + status +
                ", cargo=" + cargo +
                ", Nome='" + Nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", RG='" + RG + '\'' +
                ", Endereco='" + Endereco + '\'' +
                ", CTPS='" + CTPS + '\'' +
                ", SalarioContratual=" + SalarioContratual +
                ", CargaHoraria=" + CargaHoraria +
                ", FonePessoal='" + FonePessoal + '\'' +
                ", FoneRecados='" + FoneRecados + '\'' +
                ", Titulo='" + Titulo + '\'' +
                ", CarteiraDeReservista='" + CarteiraDeReservista + '\'' +
                ", DataNascimento=" + DataNascimento +
                ", Pis='" + Pis + '\'' +
                ", RegistroProfissional='" + RegistroProfissional + '\'' +
                ", Email='" + Email + '\'' +
                ", Sindicato='" + Sindicato + '\'' +
                ", Setor='" + Setor + '\'' +
                ", CNH='" + CNH + '\'' +
                ", DataAdmissao=" + DataAdmissao +
                ", RacaCor='" + RacaCor + '\'' +
                ", Religiao='" + Religiao + '\'' +
                ", DoadorSangue=" + DoadorSangue +
                ", Nacionalidade='" + Nacionalidade + '\'' +
                ", RedeSocial='" + RedeSocial + '\'' +
                ", AreaAtuacao='" + AreaAtuacao + '\'' +
                ", Matricula='" + Matricula + '\'' +
                ", Idiomas='" + Idiomas + '\'' +
                ", HoraExtra=" + HoraExtra +
                ", HoraEntrada=" + HoraEntrada +
                ", HoraSaida=" + HoraSaida +
                '}';
    }
}

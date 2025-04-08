package com.example.AtividadePontuada.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "Tab_funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "O nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "O cpf não pode ser vazio")
    private String cpf;

    @NotBlank(message = "A data de nascimento não pode ser vazia")
    private String dataNascimento;

    @NotNull(message = "O Sexo não pode ser vazio")
    private Sexo sexo;

    @NotNull(message = "O setor não pode ser vazio")
    private Setor setor;

    @NotNull(message = "O Estado civil não pode ser vazio")
    private EstadoCivil estadoCivil;

    @NotNull(message = "O cpf não pode ser vazio")
    private double salario;

    @NotBlank(message = "O email não deve ser vazio")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Funcionario() {
    }

    public Funcionario(long id, String nome, String cpf, String dataNascimento, Sexo sexo, Setor setor, EstadoCivil estadoCivil, double salario, String email, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.setor = setor;
        this.estadoCivil = estadoCivil;
        this.salario = salario;
        this.email = email;
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "O nome não pode ser vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome não pode ser vazio") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O cpf não pode ser vazio") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank(message = "O cpf não pode ser vazio") String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank(message = "A data de nascimento não pode ser vazia") String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotBlank(message = "A data de nascimento não pode ser vazia") String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotNull(message = "O Sexo não pode ser vazio") Sexo getSexo() {
        return sexo;
    }

    public void setSexo(@NotNull(message = "O Sexo não pode ser vazio") Sexo sexo) {
        this.sexo = sexo;
    }

    public @NotNull(message = "O setor não pode ser vazio") Setor getSetor() {
        return setor;
    }

    public void setSetor(@NotNull(message = "O setor não pode ser vazio") Setor setor) {
        this.setor = setor;
    }

    public @NotNull(message = "O Estado civil não pode ser vazio") EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(@NotNull(message = "O Estado civil não pode ser vazio") EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @NotNull(message = "O cpf não pode ser vazio")
    public double getSalario() {
        return salario;
    }

    public void setSalario(@NotNull(message = "O cpf não pode ser vazio") double salario) {
        this.salario = salario;
    }

    public @NotBlank(message = "O email não deve ser vazio") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O email não deve ser vazio") String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", sexo=" + sexo +
                ", setor=" + setor +
                ", estadoCivil=" + estadoCivil +
                ", salario=" + salario +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
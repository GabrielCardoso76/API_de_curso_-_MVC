package com.example.API_Curso.model;

public class Professor {
    private Long id;
    private String nome;
    private String cpf;
    private double salario;

    public Professor(Long id, String nome, String cpf, double salario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

package com.example.API_Curso.model;

import java.util.ArrayList;

public class Curso {
    private Long id;
    private String nome;
    private int numeroSala;
    private ArrayList<Aluno> alunos;
    private Professor professor;

    public Curso(Long id, String nome, int numeroSala, ArrayList<Aluno> alunos, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.numeroSala = numeroSala;
        this.alunos = alunos;
        this.professor = professor;
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

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}

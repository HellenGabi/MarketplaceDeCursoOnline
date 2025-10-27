package org.example.model;

import java.time.LocalDate;

public class Aluno {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private int idade;
    private String cursoDesejado;
    private LocalDate dataEntrada;


    public Aluno(int id, String nome, String cpf, String email, int idade, String cursoDesejado, LocalDate dataEntrada) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.idade = idade;
        this.cursoDesejado = cursoDesejado;
        this.dataEntrada = dataEntrada;
    }

    public Aluno(String nome,String cpf, String email, int idade, String cursoDesejado, LocalDate dataEntrada) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.idade = idade;
        this.cursoDesejado = cursoDesejado;
        this.dataEntrada = dataEntrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
}
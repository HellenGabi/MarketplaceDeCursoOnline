package org.example.MODEL;

public class Curso {

    private int id;
    private String nome;
    private int idProfessor;
    private int cargaHoraria;
    private String status;
    private String descricao;


    public Curso(int id, String nome, int idProfessor, int cargaHoraria, String status, String descricao) {
        this.id = id;
        this.nome = nome;
        this.idProfessor = idProfessor;
        this.cargaHoraria = cargaHoraria;
        this.status = status;
        this.descricao = descricao;
    }

    public Curso(String nome, int idProfessor, int cargaHoraria, String status, String descricao) {
        this.nome = nome;
        this.idProfessor = idProfessor;
        this.cargaHoraria = cargaHoraria;
        this.status = status;
        this.descricao = descricao;
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

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

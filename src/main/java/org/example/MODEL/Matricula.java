package org.example.MODEL;

import java.time.LocalDate;

public class Matricula {

    private int id;
    private int idAluno;
    private int idCurso;
    private LocalDate dataEntrada;
    private int nota;


    public Matricula(int id, int idAluno, int idCurso, LocalDate dataEntrada, int nota) {
        this.id = id;
        this.idAluno = idAluno;
        this.idCurso = idCurso;
        this.dataEntrada = dataEntrada;
        this.nota = nota;
    }

    public Matricula(int idAluno, int idCurso, LocalDate dataEntrada, int nota) {
        this.idAluno = idAluno;
        this.idCurso = idCurso;
        this.dataEntrada = dataEntrada;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}

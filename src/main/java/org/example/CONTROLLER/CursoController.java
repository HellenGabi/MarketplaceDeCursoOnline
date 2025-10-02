package org.example.CONTROLLER;

import org.example.MODEL.Curso;
import org.example.SERVICE.CursoService;

import java.util.List;

public class CursoController {

        private CursoService cursoService;

        public CursoController(CursoService cursoService) {
            this.cursoService = cursoService;
        }

        public void cadastrarCurso(String nome, int idProfessor, int cargaHoraria, String status, String descricao) {
            Curso curso = new Curso(nome, idProfessor, cargaHoraria, status, descricao);
            cursoService.cadastrarCurso(curso);
        }

        public List<Curso> listarCursos() {
            return cursoService.listarCursos();
        }
    }


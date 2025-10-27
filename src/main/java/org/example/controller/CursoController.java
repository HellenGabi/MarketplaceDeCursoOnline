package org.example.controller;

import org.example.model.Curso;
import org.example.service.CursoService;
import java.util.List;


 // Comportamento: Controller — coordena operações entre View e Service/Model

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


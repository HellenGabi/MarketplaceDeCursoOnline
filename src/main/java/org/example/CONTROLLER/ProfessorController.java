package org.example.CONTROLLER;

import org.example.MODEL.Professor;
import org.example.SERVICE.ProfessorService;

import java.util.List;

public class ProfessorController {


        private ProfessorService professorService;

        public ProfessorController(ProfessorService professorService) {
            this.professorService = professorService;
        }

        public void cadastrarProfessor(String nome, String cpf, String email, int idade, String formacao) {
            Professor professor = new Professor(nome, cpf, email, idade, formacao);
            professorService.cadastrarProfessor(professor);
        }

        public List<Professor> listarProfessores() {
            return professorService.listarProfessores();
        }
    }

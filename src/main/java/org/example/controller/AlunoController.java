package org.example.controller;

import org.example.model.Aluno;
import org.example.service.AlunoService;
import java.time.LocalDate;
import java.util.List;


 //Comportamento: Controller — coordena operações entre View e Service/Model

public class AlunoController {

        private AlunoService alunoService;

        public AlunoController(AlunoService alunoService) {
            this.alunoService = alunoService;
        }

        public void cadastrarAluno(String nome, String cpf, String email, int idade, String cursoDesejado) {
            Aluno aluno = new Aluno(nome, cpf, email, idade, cursoDesejado, LocalDate.now());
            alunoService.cadastrarAluno(aluno);
        }

        public List<Aluno> listarAlunos() {
            return alunoService.listarAlunos();
        }
    }



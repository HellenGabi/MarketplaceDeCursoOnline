package org.example.service;

import org.example.DAO.AlunoDAO;
import org.example.model.Aluno;

import java.util.List;

public class AlunoService {

        private AlunoDAO alunoDAO;

        public AlunoService(AlunoDAO alunoDAO) {
            this.alunoDAO = alunoDAO;
        }

        public void cadastrarAluno(Aluno aluno) {
            alunoDAO.inserirAluno(aluno);
        }

        public List<Aluno> listarAlunos() {
            return alunoDAO.listaAluno();
        }
    }


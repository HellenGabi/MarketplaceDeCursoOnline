package org.example.view;
import org.example.CONTROLLER.AlunoController;
import org.example.model.Aluno;

import java.util.List;

public class AlunoView {

        private AlunoController alunoController;

        public AlunoView(AlunoController alunoController) {
            this.alunoController = alunoController;
        }

        public void exibirAlunos() {
            List<Aluno> alunos = alunoController.listarAlunos();
            for (Aluno aluno : alunos) {
                System.out.println(aluno.getNome());
            }
        }
    }


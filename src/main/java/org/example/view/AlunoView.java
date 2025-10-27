package org.example.view;
import org.example.controller.AlunoController;
import org.example.model.Aluno;
import java.util.List;


  // View: responsável por apresentar dados ao usuário (aqui: console).
  // View chama o controller para obter os dados.


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


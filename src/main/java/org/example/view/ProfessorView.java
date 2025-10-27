package org.example.view;

import org.example.controller.ProfessorController;
import org.example.model.Professor;
import java.util.List;


// View: responsável por apresentar dados ao usuário (aqui: console).
// View chama o controller para obter os dados.

public class ProfessorView {


    private ProfessorController professorController;

    public ProfessorView(ProfessorController professorController) {
        this.professorController = professorController;
    }

    public void exibirProfessores() {
        List<Professor> professores = professorController.listarProfessores();
        for (Professor professor : professores) {
            System.out.println(professor.getNome());
        }
    }
}

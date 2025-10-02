package org.example.VIEW;

import org.example.CONTROLLER.ProfessorController;
import org.example.MODEL.Professor;

import java.util.List;

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

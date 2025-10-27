package org.example.service;

import org.example.DAO.ProfessorDAO;
import org.example.model.Professor;

import java.util.List;

public class ProfessorService {

    private ProfessorDAO professorDAO;

    public ProfessorService(ProfessorDAO professorDAO) {
        this.professorDAO = professorDAO;
    }

    public void cadastrarProfessor(Professor professor) {
        professorDAO.inserirProfessor(professor);
    }

    public List<Professor> listarProfessores() {
        return professorDAO.listaProf();
    }
}


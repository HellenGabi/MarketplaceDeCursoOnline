package org.example.SERVICE;

import org.example.DAO.ProfessorDAO;
import org.example.MODEL.Professor;

import java.sql.SQLException;
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


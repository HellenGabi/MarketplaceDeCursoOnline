package org.example.service;

import java.util.List;
import org.example.dao.CursoDAO;
import org.example.model.Curso;

public class CursoService {

    private CursoDAO cursoDAO;

    public CursoService(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    public void cadastrarCurso(Curso curso) {
        cursoDAO.inserirCurso(curso);
    }

    public List<Curso> listarCursos() {
        return cursoDAO.listaCurso();
    }
}

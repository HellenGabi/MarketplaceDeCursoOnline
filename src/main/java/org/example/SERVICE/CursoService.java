package org.example.SERVICE;

import java.sql.SQLException;
import java.util.List;
import org.example.DAO.CursoDAO;
import org.example.MODEL.Curso;

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

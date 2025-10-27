package org.example.view;

import org.example.CONTROLLER.CursoController;
import org.example.model.Curso;

import java.util.List;

public class CursoView {

    private CursoController cursoController;

    public CursoView(CursoController cursoController) {
        this.cursoController = cursoController;
    }

    public void exibirCursos() {
        List<Curso> cursos = cursoController.listarCursos();
        for (Curso curso : cursos) {
            System.out.println(curso.getNome());
        }
    }
}

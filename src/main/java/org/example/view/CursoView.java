package org.example.view;

import org.example.controller.CursoController;
import org.example.model.Curso;
import java.util.List;


  // View: responsável por apresentar dados ao usuário (aqui: console).
 // View chama o controller para obter os dados.

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

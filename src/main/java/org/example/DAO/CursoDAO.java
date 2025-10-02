package org.example.DAO;

import org.example.DATABASE.Conexao;
import org.example.MODEL.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public void inserirCurso(Curso curso) {

        String query = "INSERT INTO Curso (nome, idProfessor, cargaHoraria, status, descricao) VALUES (?,?,?,?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getIdProfessor());
            stmt.setInt(3, curso.getCargaHoraria());
            stmt.setString(4, curso.getStatus());
            stmt.setString(5, curso.getDescricao());
            stmt.executeUpdate();

            System.out.println("Curso Cadastrado com sucesso!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Curso> listaCurso() {

        List<Curso> cursos = new ArrayList<>();

        String query = "SELECT id, nome, idProfessor, cargaHoraria, status, descricao FROM Curso";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idProfessor = rs.getInt("idProfessor");
                int cargaHoraria = rs.getInt("caraHoraria");
                String status = rs.getString("status");
                String descricao = rs.getString("descricao");
                var curso = new Curso(id, nome, idProfessor, cargaHoraria, status, descricao);
                cursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursos;
    }

    public boolean buscarCursoId(int idCurso) {

        String query = "SELECT id, nome FROM Aluno WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idCurso);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}

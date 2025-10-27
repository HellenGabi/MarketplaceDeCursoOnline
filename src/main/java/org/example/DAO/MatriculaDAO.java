package org.example.DAO;

import org.example.conexao.Conexao;
import org.example.model.Matricula;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {

    public void inserirMatricula(Matricula matricula){

        String query = "INSERT INTO Matricula(alunoId, cursoId, dataEntrada, nota)VALUES(?,?,?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, matricula.getIdAluno());
            stmt.setInt(2, matricula.getIdCurso());
            stmt.setDate(3, Date.valueOf(matricula.getDataEntrada()));
            stmt.setInt(4, matricula.getNota());
            stmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Matricula> listaMatricula(){

        List<Matricula> matriculas = new ArrayList<>();

        String query = "SELECT id, alunoId, cursoId, dataEntrada, nota FROM Matricula";

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                int alunoId = rs.getInt("alunoId");
                int cursoId = rs.getInt("cursoId");
                LocalDate dataEntrada = rs.getDate("dataEntrada").toLocalDate();
                int nota = rs.getInt("nota");
                var matricula = new Matricula(id,alunoId, cursoId, dataEntrada, nota );
                matriculas.add(matricula);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return matriculas;
    }

    public List<Matricula> buscarPorCurso(int idCurso) {
        List<Matricula> lista = new ArrayList<>();
        String sql = "SELECT * FROM Matricula WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCurso);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Matricula(
                        rs.getInt("id_aluno"),
                        rs.getInt("id_curso"),
                        rs.getDate("data").toLocalDate(),
                        rs.getInt("nota")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

 public boolean buscarMatriculaPorId(int idMatricula) {

    String query = "SELECT id, alunoId FROM Matricula WHERE id = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(query)){
        stmt.setInt(1, idMatricula);
        ResultSet rs = stmt.executeQuery();

        if(rs.next()){
            return true;
        }
    } catch (SQLException e){
        e.printStackTrace();
    }
    return false;
}

    public void deletarMatricula(int idMatricula) {
        String query = "DELETE FROM Matricula WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, idMatricula);
            stmt.executeUpdate();



        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

package org.example.DAO;

import org.example.conexao.Conexao;
import org.example.model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    public void inserirProfessor(Professor prof){

        String query = "INSERT INTO Professor(nome, cpf, email, idade, formacao) VALUES (?,?,?,?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt  = conn.prepareStatement(query)){
            stmt.setString(1, prof.getNome());
            stmt.setString(2, prof.getCpf());
            stmt.setString(3, prof.getEmail());
            stmt.setInt(4, prof.getIdade());
            stmt.setString(5, prof.getFormacao());
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Professor> listaProf(){

        List<Professor> professores = new ArrayList<>();

        String query = "SELECT id, nome, cpf, email, idade, formacao FROM Professor";

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                int idade = rs.getInt("idade");
                String formacao = rs.getString("formacao");

                var prof = new Professor(id, nome, cpf, email, idade, formacao);
                professores.add(prof);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return professores;
    }

    public boolean buscarProfessorPorId(int idProfessor) {

        String query = "SELECT id, nome FROM Professor WHERE id = ?";

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, idProfessor);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public void atualizarProfessor(int idProfessor) {
        String query = "UPDATE SET Professor";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

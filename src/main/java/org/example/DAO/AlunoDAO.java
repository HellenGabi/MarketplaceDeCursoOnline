package org.example.DAO;

import org.example.DATABASE.Conexao;
import org.example.MODEL.Aluno;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public void inserirAluno(Aluno aluno){

        String query = "INSERT INTO Aluno (nome, cpf, email, idade, cursoDesejado, dataEntrada) VALUES(?,?,?,?,?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement st = conn.prepareStatement(query)){

            st.setString(1, aluno.getNome());
            st.setString(2, aluno.getCpf());
            st.setString(3, aluno.getEmail());
            st.setInt(4, aluno.getIdade());
            st.setString(5, aluno.getCursoDesejado());
            st.setDate(6, Date.valueOf(aluno.getDataEntrada()));
            st.executeUpdate();

            System.out.println("Aluno cadastrado com sucesso!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Aluno> listaAluno (){

        List<Aluno> alunos = new ArrayList<>();

        String query =  "SELECT id, nome, cpf, email, idade, cursoDesejado, dataEntrada FROM Aluno";

        try (Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(query)){
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                int idade = rs.getInt("idade");
                String cursoDesejado = rs.getString("cursoDesejado");
                LocalDate dataEntrada = rs.getDate("dataEntrada").toLocalDate();

                var aluno = new Aluno(id, nome, cpf, email, idade, cursoDesejado, dataEntrada);
                alunos.add(aluno);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return alunos;
    }

    public boolean buscarAlunoId(int idAluno) {

        String query = "SELECT id, nome FROM Aluno WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, idAluno);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}

package org.example;


import org.example.DAO.AlunoDAO;
import org.example.DAO.CursoDAO;
import org.example.DAO.MatriculaDAO;
import org.example.DAO.ProfessorDAO;
import org.example.MODEL.Aluno;
import org.example.MODEL.Curso;
import org.example.MODEL.Matricula;
import org.example.MODEL.Professor;
import org.example.UTIL.Validacoes;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();
        CursoDAO cursoDAO = new CursoDAO();
        MatriculaDAO matriculaDAO = new MatriculaDAO();

        while (true) {
            // Exibir o menu
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Curso");
            System.out.println("4. Matricular Aluno em Curso");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarProfessor();
                    break;
                case 3:
                    cadastrarCurso();
                    break;
                case 4:
                    //matricularAluno();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarAluno() {
        System.out.println("\nCadastro de Aluno:");

        System.out.print("Informe o nome do aluno: ");
        String nomeAluno = scanner.nextLine();

        System.out.print("Informe o CPF do aluno (apenas números): ");
        String cpfAluno = scanner.nextLine();

        System.out.print("Informe o email do aluno: ");
        String emailAluno = scanner.nextLine();

        System.out.print("Informe a idade do aluno: ");
        int idadeAluno = Integer.parseInt(scanner.nextLine());

        System.out.print("Informe o curso desejado: ");
        String cursoDesejado = scanner.nextLine();

        // Validar CPF do aluno
        if (!Validacoes.validarCPF(cpfAluno)) {
            System.out.println("CPF do Aluno inválido!");
            return;
        }

        Aluno aluno = new Aluno(nomeAluno, cpfAluno, emailAluno, idadeAluno, cursoDesejado, LocalDate.now());
        AlunoDAO dao = new AlunoDAO();
        dao.inserirAluno(aluno);

        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void cadastrarProfessor() {
        System.out.println("\nCadastro de Professor:");

        System.out.print("Informe o nome do professor: ");
        String nomeProfessor = scanner.nextLine();

        System.out.print("Informe o CPF do professor (apenas números): ");
        String cpfProfessor = scanner.nextLine();

        System.out.print("Informe o email do professor: ");
        String emailProfessor = scanner.nextLine();

        System.out.print("Informe a idade do professor: ");
        int idadeProfessor = Integer.parseInt(scanner.nextLine());

        System.out.print("Informe a formação do professor: ");
        String formacaoProfessor = scanner.nextLine();

        Professor professor = new Professor(nomeProfessor, cpfProfessor, emailProfessor, idadeProfessor, formacaoProfessor);
        ProfessorDAO dao = new ProfessorDAO();
        dao.inserirProfessor(professor);

        System.out.println("Professor cadastrado com sucesso!");
    }

    private static void cadastrarCurso() {
        System.out.println("\nCadastro de Curso:");

        System.out.print("Informe o nome do curso: ");
        String nomeCurso = scanner.nextLine();

        System.out.print("Informe a carga horária do curso: ");
        int cargaHorariaCurso = Integer.parseInt(scanner.nextLine());

        System.out.print("Informe a descrição do curso: ");
        String descricaoCurso = scanner.nextLine();

        System.out.print("Digite o ID do professor: ");
        int idProfessor = Integer.parseInt(scanner.nextLine());


        CursoDAO dao = new CursoDAO();
        if(dao.buscarCursoId(idProfessor)){
            System.out.println("Professor não encontrado!");
            return;
        }

        Curso curso = new Curso(nomeCurso, idProfessor, cargaHorariaCurso, "EM_ANDAMENTO", descricaoCurso);
        dao.inserirCurso(curso);

        System.out.println("Curso cadastrado com sucesso!");
    }

//    private static void matricularAluno(AlunoDAO alunoDAO, CursoDAO cursoDAO, MatriculaDAO matriculaDAO) {
//        System.out.println("\nMatrícula de Aluno em Curso:");
//
//        System.out.println("Lista de Alunos:");
//        for (Aluno a : alunoDAO.listaAluno()) {
//            System.out.println("ID: " + a.getId() + " - Nome: " + a.getNome());
//        }
//
//        System.out.println("\nLista de Cursos:");
//        for (Curso c : cursoDAO.listaCurso()) {
//            System.out.println("ID: " + c.getId() + " - Nome: " + c.getNome());
//        }
//
//        System.out.print("\nInforme o ID do aluno: ");
//        int idAluno = Integer.parseInt(scanner.nextLine());
//
//        System.out.print("Informe o ID do curso: ");
//        int idCurso = Integer.parseInt(scanner.nextLine());
//
//        boolean aluno = alunoDAO.buscarAlunoId(idAluno);
//        boolean curso = cursoDAO.buscarCursoId(idCurso);
//
//        if (!aluno) {
//            System.out.println("Aluno não encontrado!");
//            return;
//        }
//
//        if (!curso) {
//            System.out.println("Curso não encontrado!");
//            return;
//        }
//
//        // Criar a matrícula
//        Matricula matricula = new Matricula(aluno.getId(), curso.getId(), LocalDate.now(), 0);
//        matriculaDAO.inserirMatricula(matricula);
//
//        System.out.println("Aluno matriculado com sucesso no curso " + curso.getNome());
//    }
}

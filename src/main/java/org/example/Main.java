package org.example;


import org.example.DAO.AlunoDAO;
import org.example.DAO.CursoDAO;
import org.example.DAO.MatriculaDAO;
import org.example.DAO.ProfessorDAO;
import org.example.model.Aluno;
import org.example.model.Curso;
import org.example.model.Matricula;
import org.example.model.Professor;
import org.example.util.Validacoes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
            System.out.println("--------------------------------------------------------");
            System.out.println("=== Menu ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Curso");
            System.out.println("4. Matricular Aluno em Curso");
            System.out.println("5. Listar Alunos matriculados");
            System.out.println("6. Listar Professores matriculados");
            System.out.println("7. Listar Cursos");
            System.out.println("8. Associar Professor ao Curso");
            System.out.println("9. Cancelar Matricula");
            System.out.println("10. Buscar Aluno por Curso");
            System.out.println("11. Sair");
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
                    matricularAluno();
                    break;
                case 5:
                    listarAlunos();
                    break;
                case 6:
                    listarProfessores();
                    break;
                case 7:
                    listarCursos();
                    break;
                case 8:
                    associarProfACurso();
                    break;
                case 9:
                    cancelamentoMatricula();
                    break;
                case 10:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarAluno() {
        System.out.println("\n -- Cadastro de Aluno --");

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
    }

    private static void cadastrarProfessor() {
        System.out.println("\n -- Cadastro de Professor --");

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
        System.out.println("\n -- Cadastro de Curso -- ");

        System.out.print("Informe o nome do curso: ");
        String nomeCurso = scanner.nextLine();

        System.out.print("Informe a carga horária do curso: ");
        int cargaHorariaCurso = Integer.parseInt(scanner.nextLine());

        System.out.print("Informe a descrição do curso: ");
        String descricaoCurso = scanner.nextLine();

        List<Integer> opcoesProf = new ArrayList<>();
        ProfessorDAO profDAO = new ProfessorDAO();

        System.out.println("Lista de professores matriculados: ");
        for (Professor p : profDAO.listaProf()) {
            System.out.println("\n ---- PROFESSORES ----");
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Formação: " + p.getFormacao());

            opcoesProf.add(p.getId());
        }

        System.out.print("Digite o ID do professor: ");
        int idProfessor = Integer.parseInt(scanner.nextLine());

        CursoDAO dao = new CursoDAO();
        if(!dao.buscarCursoId(idProfessor)){
            System.out.println("Professor não encontrado!");
            return;
        }

        Curso curso = new Curso(nomeCurso, idProfessor, cargaHorariaCurso, "EM_ANDAMENTO", descricaoCurso);
        dao.inserirCurso(curso);

    }

   private static void matricularAluno() {
       AlunoDAO alunoDAO = new AlunoDAO();
       CursoDAO cursoDAO = new CursoDAO();
       MatriculaDAO matriculaDAO = new MatriculaDAO();

        System.out.println("\n -- Matrícula de Aluno em Curso --    ");

       System.out.println("Lista de Alunos:");
       for (Aluno a : alunoDAO.listaAluno()) {
           System.out.println("ID: " + a.getId() + " - Nome: " + a.getNome());
       }
       System.out.println("--------------------------------------------------------");

       System.out.println("\nLista de Cursos:");
       for (Curso c : cursoDAO.listaCurso()) {
           System.out.println("ID: " + c.getId() + " - Nome: " + c.getNome());
       }
       System.out.println("--------------------------------------------------------");


       System.out.print("\nInforme o ID do aluno: ");
       int idAluno = Integer.parseInt(scanner.nextLine());

       System.out.print("Informe o ID do curso: ");
       int idCurso = Integer.parseInt(scanner.nextLine());

       boolean aluno = alunoDAO.buscarAlunoId(idAluno);
       boolean curso = cursoDAO.buscarCursoId(idCurso);

       if (!aluno) {
           System.out.println("Aluno não encontrado!");
           return;
       }

       if (!curso) {
           System.out.println("Curso não encontrado!");
           return;
       }

       // Criar a matrícula
       Matricula matricula = new Matricula(idAluno, idCurso, LocalDate.now(), 0);
       matriculaDAO.inserirMatricula(matricula);

       System.out.println("Aluno matriculado com sucesso no curso ");
   }
   public static void listarAlunos(){
        AlunoDAO dao = new AlunoDAO();

       System.out.println("Lista de alunos matriculados: ");
       for (Aluno a : dao.listaAluno()) {
           System.out.println("\n ---- ALUNOS ----");
           System.out.println("ID: " + a.getId());
           System.out.println("Nome: " + a.getNome());
           System.out.println("Curso Desejado: " + a.getCursoDesejado());
           System.out.println("--------------------------------------------------------");

       }
   }
    public static void listarProfessores(){
        ProfessorDAO dao = new ProfessorDAO();

        System.out.println("Lista de professores matriculados: ");
        for (Professor p : dao.listaProf()) {
            System.out.println("\n ---- PROFESSORES ----");
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Formação: " + p.getFormacao());
            System.out.println("--------------------------------------------------------");

        }
    }

    public static void listarCursos(){
        CursoDAO dao = new CursoDAO();

        System.out.println("Lista de cursos: ");
        System.out.println("-------------------------------------------");
        for (Curso c : dao.listaCurso()) {
            System.out.println("\n---------------- CURSOS ----------------");
            System.out.println("ID: " + c.getId());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Carga Horaria: " + c.getCargaHoraria());
            System.out.println("Status: " + c.getStatus());
            System.out.println("Descrição: " + c.getDescricao());
            System.out.println("-------------------------------------------");
        }
    }

    public static void associarProfACurso() {
        System.out.println("Selecione a ordem que deseja: ");

        List<Integer> opcoesProf = new ArrayList<>();
        var profDAO = new ProfessorDAO();
        List<Professor> listarProfessor = profDAO.listaProf();

        for (Professor p : listarProfessor) {
            System.out.println("\n------- PROFESSOR ----------");
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Formação: " + p.getFormacao());
            opcoesProf.add(p.getId());
            System.out.println("--------------------------------------------------------");

        }

        System.out.println("Digite o ID do professor que deseja: ");
        int idProf = scanner.nextInt();
        scanner.nextLine();
        System.out.println("--------------------------------------------------------");


        if (opcoesProf.contains(idProf)) {
            List<Integer> opcoesCurso = new ArrayList<>();
            var cursDAO = new CursoDAO();
            List<Curso> listCurso = cursDAO.listaCurso();

            for (Curso c : listCurso) {
                System.out.println("\n ----------- CURSO ------------");
                System.out.println("ID: " + c.getId());
                System.out.println("Nome: " + c.getNome());
                System.out.println("Carga Horaria: " + c.getCargaHoraria());
                System.out.println("Status: " + c.getStatus());
                System.out.println("Descrição: " + c.getDescricao());
                System.out.println("-------------------------------------------");
                opcoesCurso.add(c.getId());
            }

            System.out.println("Digite o ID do curso que deseja: ");
            int idCurso = scanner.nextInt();
            scanner.nextLine();

            if (opcoesCurso.contains(idCurso)) {
                // Associação no banco
                profDAO.associarProfessorCurso(idProf, idCurso);

                System.out.println("Professor ID " + idProf +
                        " associado ao curso ID " + idCurso + " com sucesso!");
            } else {
                System.out.println("ID de curso inválido.");
            }
        } else {
            System.out.println("ID de professor inválido.");
        }
    }

    public static void cancelamentoMatricula(){
        MatriculaDAO dao = new MatriculaDAO();
        List<Matricula> matriculas = dao.listaMatricula();

        for (Matricula matricula : matriculas) {
            System.out.println("--------------------------------------------------------");

            System.out.println("\n MATRICULAS ");
            System.out.println("Id: " + matricula.getId());
            System.out.println("Id Aluno: " + matricula.getIdAluno());
            System.out.println("Id Curso: " + matricula.getIdCurso());
            System.out.println("Data entrada: " + matricula.getDataEntrada());
            System.out.println("--------------------------------------------------------");

        }

        System.out.println("Digite o ID da matricula q deseja com: ");

        int idAluguel = scanner.nextInt();
        scanner.nextLine();
        dao.deletarMatricula(idAluguel);
        System.out.println("Deletado com sucesso!!");

    }


    }
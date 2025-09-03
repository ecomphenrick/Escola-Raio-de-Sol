package org.example.view;

import org.example.model.Escola;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBusca {
    Scanner sc = new Scanner(System.in);

    public void ExibirMenu(Escola escola) {
        int acao = -1;

        do {
            System.out.println("\nBusca\n");
            System.out.println("Você deseja buscar: ");
            System.out.println("0 - Aluno");
            System.out.println("1 - Professor");
            System.out.println("2 - Turma");
            System.out.println("3 - Sair");

            try {
                acao = sc.nextInt();
                sc.nextLine(); // limpar buffer

                switch (acao) {
                    case 0:
                        if (escola.getAlunos() == null || escola.getAlunos().isEmpty()) {
                            System.out.println("Não há alunos cadastrados.");
                        } else {
                            MenuBuscaAluno menuBuscaAluno = new MenuBuscaAluno();
                            menuBuscaAluno.ExibirMenuAluno(escola);
                        }
                        break;

                    case 1:
                        if (escola.getProfessoresGeral() == null || escola.getProfessoresGeral().isEmpty()) {
                            System.out.println("Não há professores cadastrados.");
                        } else {
                            MenuBuscaProfessor menuBuscaProfessor = new MenuBuscaProfessor();
                            menuBuscaProfessor.ExibirMenuProfessor(escola);
                        }
                        break;

                    case 2:
                        if (escola.getTurmas() == null || escola.getTurmas().isEmpty()) {
                            System.out.println("Não existem turmas cadastradas.");
                        } else {
                            MenuBuscaTurma menuBuscaTurma = new MenuBuscaTurma();
                            menuBuscaTurma.ExibirMenuTurma(escola);
                        }
                        break;

                    case 3:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção Inválida.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida. Digite apenas números.");
                sc.nextLine(); // limpar buffer para evitar loop infinito
            } catch (Exception e) {
                System.out.println("❌ Ocorreu um erro inesperado: " + e.getMessage());
                sc.nextLine();
            }

        } while (acao != 3);
    }
}

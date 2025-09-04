package org.example.view;

import org.example.model.Escola;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBusca {
    Scanner sc = new Scanner(System.in);

    public void ExibirMenu(Escola escola) {
        int acao = -1;

        do {
            System.out.println("\n====================================");
            System.out.println("               Busca                ");
            System.out.println("====================================\n");

            System.out.println("O que você deseja buscar?");
            System.out.println("[0] Aluno");
            System.out.println("[1] Professor");
            System.out.println("[2] Turma");
            System.out.println("[3] Responsável");
            System.out.println("[4] Voltar ao menu principal");
            System.out.print("\nOpção: ");

            try {
                acao = sc.nextInt();
                sc.nextLine();

                System.out.println();

                switch (acao) {
                    case 0:
                        if (escola.getAlunos() == null || escola.getAlunos().isEmpty()) {
                            System.out.println("⚠️ Não há alunos cadastrados.");
                        } else {
                            MenuBuscaAluno menuBuscaAluno = new MenuBuscaAluno();
                            menuBuscaAluno.ExibirMenuAluno(escola);
                        }
                        break;

                    case 1:
                        if (escola.getProfessoresGeral() == null || escola.getProfessoresGeral().isEmpty()) {
                            System.out.println("⚠️ Não há professores cadastrados.");
                        } else {
                            MenuBuscaProfessor menuBuscaProfessor = new MenuBuscaProfessor();
                            menuBuscaProfessor.ExibirMenuProfessor(escola);
                        }
                        break;

                    case 2:
                        if (escola.getTurmas() == null || escola.getTurmas().isEmpty()) {
                            System.out.println("⚠️ Não existem turmas cadastradas.");
                        } else {
                            MenuBuscaTurma menuBuscaTurma = new MenuBuscaTurma();
                            menuBuscaTurma.ExibirMenuTurma(escola);
                        }
                        break;

                    case 3:
                        MenuBuscaResponsavel menuBuscaResponsavel = new MenuBuscaResponsavel();
                        menuBuscaResponsavel.ExibirMenuResponsavel(escola);
                        break;

                    case 4:
                        System.out.println("🔙 Retornando ao menu principal...");
                        break;

                    default:
                        System.out.println("⚠️ Opção inválida. Tente novamente.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("\n❌ Entrada inválida. Digite apenas números.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("\n❌ Ocorreu um erro inesperado: " + e.getMessage());
                sc.nextLine();
            }

        } while (acao != 4);
    }
}

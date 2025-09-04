package org.example.view;

import org.example.model.Aluno;
import org.example.model.Escola;
import org.example.model.Turma;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuBuscaTurma {
    Scanner sc = new Scanner(System.in);

    public void ExibirMenuTurma(Escola escola) {
        List<Turma> turmas = escola.getTurmas();

        try {
            System.out.println("\n====================================");
            System.out.println("            Gerenciar Turma          ");
            System.out.println("====================================\n");

            System.out.println("[0] Ler informações");
            System.out.println("[1] Atualizar");
            System.out.println("[2] Deletar");
            System.out.println("[3] Voltar");
            System.out.print("\nOpção: ");

            int acaoTurma = sc.nextInt();
            sc.nextLine();

            if (turmas == null || turmas.isEmpty()) {
                System.out.println("\n❌ Não existem turmas cadastradas.");
                return;
            }

            System.out.println("\nEscolha a turma:");
            for (int i = 0; i < turmas.size(); i++) {
                Turma t = turmas.get(i);
                System.out.println(i + ": " + t.getSerie() + " - " + t.getAnoLetivo());
            }

            System.out.print("\nOpção: ");
            int escolhaTurma = sc.nextInt();
            sc.nextLine();

            if (escolhaTurma < 0 || escolhaTurma >= turmas.size()) {
                System.out.println("\n❌ Escolha inválida. Operação cancelada.");
                return;
            }

            Turma turmaEscolhida = turmas.get(escolhaTurma);

            switch (acaoTurma) {
                case 0:
                    System.out.println("\n--- Informações da Turma ---");
                    System.out.println("Turma: " + turmaEscolhida.getSerie() + " - " + turmaEscolhida.getAnoLetivo());
                    if (turmaEscolhida.getProfessor() != null) {
                        System.out.println("Professor: " + turmaEscolhida.getProfessor().getNome());
                    } else {
                        System.out.println("Professor: Sem professor atribuído.");
                    }

                    System.out.println("Alunos:");
                    List<Aluno> alunos = turmaEscolhida.getAlunos();
                    if (alunos != null && !alunos.isEmpty()) {
                        for (Aluno aluno : alunos) {
                            System.out.println(" - " + aluno.getNome());
                        }
                    } else {
                        System.out.println("Nenhum aluno cadastrado nesta turma.");
                    }
                    break;

                case 1:
                    System.out.println("\n⚠ Atualização ainda não implementada.");
                    break;

                case 2:
                    turmas.remove(turmaEscolhida);
                    System.out.println("\n✅ Turma removida com sucesso.");
                    break;

                case 3:
                    System.out.println("\n🔙 Retornando ao menu anterior...");
                    break;

                default:
                    System.out.println("\n⚠️ Opção inválida. Tente novamente.");
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("\n❌ Entrada inválida. Digite apenas números.");
            sc.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\n❌ Índice inválido. Operação cancelada.");
        } catch (Exception e) {
            System.out.println("\n❌ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}



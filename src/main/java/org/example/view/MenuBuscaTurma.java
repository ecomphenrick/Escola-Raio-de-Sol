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
            System.out.println("0 - Ler");
            System.out.println("1 - Atualizar");
            System.out.println("2 - Deletar");
            System.out.println("3 - Sair");

            int acaoTurma = sc.nextInt();
            sc.nextLine(); // limpar buffer

            if (turmas == null || turmas.isEmpty()) {
                System.out.println("❌ Não existem turmas cadastradas.");
                return;
            }

            System.out.println("Em qual turma?");
            for (int i = 0; i < turmas.size(); i++) {
                Turma t = turmas.get(i);
                System.out.println(i + ": " + t.getSerie() + " - " + t.getAnoLetivo());
            }

            System.out.print("Escolha a turma: ");
            int escolhaTurma = sc.nextInt();
            sc.nextLine(); // limpar buffer

            if (escolhaTurma < 0 || escolhaTurma >= turmas.size()) {
                System.out.println("❌ Escolha inválida. Operação cancelada.");
                return;
            }

            Turma turmaEscolhida = turmas.get(escolhaTurma);

            switch (acaoTurma) {
                case 0:
                    System.out.println("Turma: " + turmaEscolhida.getSerie() + " - " + turmaEscolhida.getAnoLetivo());
                    if (turmaEscolhida.getProfessor() != null) {
                        System.out.println("Professor: " + turmaEscolhida.getProfessor().getNome());
                    } else {
                        System.out.println("Professor: Sem professor atribuído.");
                    }

                    System.out.println("Alunos: ");
                    List<Aluno> alunos = turmaEscolhida.getAlunos();
                    if (alunos != null && !alunos.isEmpty()) {
                        for (Aluno aluno : alunos) {
                            System.out.println("Nome: " + aluno.getNome());
                        }
                    } else {
                        System.out.println("Nenhum aluno cadastrado nesta turma.");
                    }
                    break;

                case 1:
                    System.out.println("⚠ Atualização ainda não implementada.");
                    break;

                case 2:
                    turmas.remove(turmaEscolhida);
                    System.out.println("✅ Turma removida com sucesso.");
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("❌ Opção inválida.");
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("❌ Entrada inválida. Digite apenas números.");
            sc.nextLine(); // limpar buffer
        } catch (IndexOutOfBoundsException e) {
            System.out.println("❌ Índice inválido. Operação cancelada.");
        } catch (Exception e) {
            System.out.println("❌ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}


package org.example.view;

import org.example.controller.RemoverProfessor;
import org.example.model.Escola;
import org.example.model.Professor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBuscaProfessor {
    Scanner sc = new Scanner(System.in);

    public void ExibirMenuProfessor(Escola escola) {
        try {
            System.out.println("\n====================================");
            System.out.println("          Gerenciar Professor        ");
            System.out.println("====================================\n");

            System.out.println("[0] Ler informações");
            System.out.println("[1] Atualizar");
            System.out.println("[2] Deletar");
            System.out.println("[3] Voltar");
            System.out.print("\nOpção: ");

            int acao = sc.nextInt();
            sc.nextLine();

            System.out.print("\nDigite o nome do professor: ");
            String nome = sc.nextLine().trim();

            Professor buscado = buscarProfessorPorNome(escola, nome);

            if (buscado == null) {
                System.out.println("\n❌ Não há professor com esse nome cadastrado.");
            } else {
                switch (acao) {
                    case 0:
                        System.out.println("\n--- Informações do Professor ---");
                        System.out.println("Nome: " + buscado.getNome());
                        System.out.println("Data de Nascimento: " + buscado.getDataNascimento());
                        System.out.println("Endereço: " + buscado.getEndereco().bairro + " - " + buscado.getEndereco().cidade);
                        System.out.println("Formação: " + buscado.getFormacao());
                        if (buscado.getTurma() != null) {
                            System.out.println("Turma: " + buscado.getTurma().getSerie() + " - " + buscado.getTurma().getAnoLetivo());
                        } else {
                            System.out.println("Turma: Sem turma atribuída.");
                        }
                        break;
                    case 1:
                        AtualizarProfessor atualizarProfessor = new AtualizarProfessor();
                        atualizarProfessor.AtualizarProfessor(escola, buscado);
                        break;
                    case 2:
                        RemoverProfessor removerProfessor = new RemoverProfessor();
                        removerProfessor.RemoverProfessor(escola, buscado);
                        break;
                    case 3:
                        System.out.println("\n🔙 Retornando ao menu anterior...");
                        break;
                    default:
                        System.out.println("\n⚠️ Opção inválida. Tente novamente.");
                        break;
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("\n❌ Entrada inválida. Digite apenas números para a opção.");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("\n❌ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    private Professor buscarProfessorPorNome(Escola escola, String nome) {
        if (escola.getProfessores() != null) {
            for (Professor p : escola.getProfessores()) {
                if (p.getNome().equalsIgnoreCase(nome)) return p;
            }
        }
        if (escola.getProfessoresSemTurma() != null) {
            for (Professor p : escola.getProfessoresSemTurma()) {
                if (p.getNome().equalsIgnoreCase(nome)) return p;
            }
        }
        return null;
    }
}



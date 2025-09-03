package org.example.view;

import org.example.controller.AtualizarProfessor;
import org.example.model.Escola;
import org.example.model.Professor;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuBuscaProfessor {
    Scanner sc = new Scanner(System.in);

    public void ExibirMenuProfessor(Escola escola) {
        List<Professor> professores = escola.getProfessoresGeral();

        try {
            System.out.println("0 - Ler");
            System.out.println("1 - Atualizar");
            System.out.println("2 - Deletar");
            System.out.println("3 - Sair");

            int acao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            System.out.println("Digite o nome do professor: ");
            String nome = sc.nextLine().trim();

            Professor buscado = null;
            for (Professor professor : professores) {
                if (professor.getNome().equalsIgnoreCase(nome)) {
                    buscado = professor;
                    break;
                }
            }

            if (buscado == null) {
                System.out.println("❌ Não há professor com esse nome.");
            } else {
                switch (acao) {
                    case 0:
                        System.out.println("Nome: " + buscado.getNome());
                        System.out.println("Data de Nascimento: " + buscado.getDataNascimento());
                        System.out.println("Endereço: " + buscado.getEndereco().toString());
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
                        professores.remove(buscado);
                        System.out.println("✅ Professor removido com sucesso.");
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("❌ Opção inválida.");
                        break;
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("❌ Entrada inválida. Digite apenas números para a opção.");
            sc.nextLine(); // limpar buffer
        } catch (Exception e) {
            System.out.println("❌ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}


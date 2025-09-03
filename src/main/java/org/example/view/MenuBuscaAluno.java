package org.example.view;

import org.example.controller.AtualizarAluno;
import org.example.model.Aluno;
import org.example.model.Escola;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuBuscaAluno {
    Scanner sc = new Scanner(System.in);

    public void ExibirMenuAluno(Escola escola) {
        List<Aluno> alunos = escola.getAlunos();

        try {
            System.out.println("0 - Ler");
            System.out.println("1 - Atualizar");
            System.out.println("2 - Deletar");
            System.out.println("3 - Sair");

            int acao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            System.out.println("Digite o nome do aluno: ");
            String nome = sc.nextLine().trim();

            Aluno buscado = null;
            for (Aluno aluno : alunos) {
                if (aluno.getNome().equalsIgnoreCase(nome)) {
                    buscado = aluno;
                    break;
                }
            }

            if (buscado == null) {
                System.out.println("❌ Não há aluno com esse nome aqui.");
            } else {
                switch (acao) {
                    case 0:
                        System.out.println("Nome: " + buscado.getNome());
                        System.out.println("Data de Nascimento: " + buscado.getDataNascimento());
                        System.out.println("Endereço: " + buscado.getEndereco().toString());
                        System.out.println("Naturalidade: " + buscado.getNaturalidade());
                        System.out.println("Responsável: " + buscado.getResponsavel().getNome());
                        System.out.println("Turma: " + buscado.getTurma().getSerie() + " - " + buscado.getTurma().getAnoLetivo());
                        break;
                    case 1:
                        AtualizarAluno atualizarAluno = new AtualizarAluno();
                        atualizarAluno.AtualizarAluno(escola, buscado);
                        break;
                    case 2:
                        alunos.remove(buscado);
                        System.out.println("✅ Aluno removido com sucesso.");
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


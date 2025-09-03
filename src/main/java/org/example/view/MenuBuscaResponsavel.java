package org.example.view;

import org.example.controller.AtualizarResponsavel;
import org.example.controller.Cadastro;
import org.example.controller.RemoverResponsavel;
import org.example.model.Escola;
import org.example.model.Responsavel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBuscaResponsavel {
    Scanner sc = new Scanner(System.in);
    Cadastro cadastro = new Cadastro();

    public void ExibirMenuResponsavel(Escola escola) {
        try {
            System.out.println("0 - Ler");
            System.out.println("1 - Atualizar");
            System.out.println("2 - Deletar");
            System.out.println("3 - Sair");

            int acao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            System.out.println("Digite o nome do responsável: ");
            String nome = sc.nextLine().trim();

            Responsavel buscado = buscarResponsavelPorNome(escola, nome);

            if (buscado == null) {
                System.out.println("❌ Não há responsável com esse nome.");
            } else {
                switch (acao) {
                    case 0:
                        // Ler informações
                        System.out.println("Nome: " + buscado.getNome());
                        System.out.println("Data de Nascimento: " + buscado.getDataNascimento());
                        System.out.println("Telefone: " + buscado.getTelefone());
                        System.out.println("Endereço: " + buscado.getEndereco().bairro + " - " + buscado.getEndereco().cidade);
                        break;
                    case 1:
                        AtualizarResponsavel atualizarResponsavel = new AtualizarResponsavel();
                        atualizarResponsavel.AtualizarResponsavel(escola, buscado);
                        break;
                    case 2:
                        RemoverResponsavel removerResponsavel = new RemoverResponsavel();
                        removerResponsavel.RemoverResponsavel(escola, buscado);
                        System.out.println("✅ Responsável removido e desvinculado dos alunos.");
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

    private Responsavel buscarResponsavelPorNome(Escola escola, String nome) {
        if (escola.getResponsaveis() != null) {
            for (Responsavel r : escola.getResponsaveis()) {
                if (r.getNome().equalsIgnoreCase(nome)) return r;
            }
        }
        return null;
    }
}



package org.example.view;

import org.example.controller.RemoverResponsavel;
import org.example.model.Escola;
import org.example.model.Responsavel;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe responsável por exibir o menu de gerenciamento de responsáveis.
 * <p>
 * Permite ao usuário ler informações de um responsável, atualizar seus dados ou deletá-lo.
 * O responsável é buscado pelo nome.
 * </p>
 *
 * Autor: Henrick
 * Versão: 1.0
 */
public class MenuBuscaResponsavel {
    Scanner sc = new Scanner(System.in);

    /**
     * Exibe o menu de gerenciamento de responsáveis.
     * <p>
     * As opções disponíveis são:
     * <ul>
     *     <li>0 - Ler informações do responsável</li>
     *     <li>1 - Atualizar dados do responsável</li>
     *     <li>2 - Deletar responsável</li>
     *     <li>3 - Voltar ao menu anterior</li>
     * </ul>
     *
     * @param escola Escola cujos responsáveis serão gerenciados
     */
    public void ExibirMenuResponsavel(Escola escola) {
        try {
            System.out.println("\n====================================");
            System.out.println("        Gerenciar Responsável        ");
            System.out.println("====================================\n");

            System.out.println("[0] Ler informações");
            System.out.println("[1] Atualizar");
            System.out.println("[2] Deletar");
            System.out.println("[3] Voltar");
            System.out.print("\nOpção: ");

            int acao = sc.nextInt();
            sc.nextLine();

            System.out.print("\nDigite o nome do responsável: ");
            String nome = sc.nextLine().trim();

            Responsavel buscado = buscarResponsavelPorNome(escola, nome);

            if (buscado == null) {
                System.out.println("\n❌ Não há responsável com esse nome cadastrado.");
            } else {
                switch (acao) {
                    case 0:
                        System.out.println("\n--- Informações do Responsável ---");
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
                        System.out.println("\n✅ Responsável removido e desvinculado dos alunos.");
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

    /**
     * Busca um responsável pelo nome na lista de responsáveis da escola.
     *
     * @param escola Escola cujos responsáveis serão pesquisados
     * @param nome Nome do responsável a ser buscado
     * @return O objeto Responsavel correspondente ao nome, ou null se não encontrado
     */
    private Responsavel buscarResponsavelPorNome(Escola escola, String nome) {
        if (escola.getResponsaveis() != null) {
            for (Responsavel r : escola.getResponsaveis()) {
                if (r.getNome().equalsIgnoreCase(nome)) return r;
            }
        }
        return null;
    }
}





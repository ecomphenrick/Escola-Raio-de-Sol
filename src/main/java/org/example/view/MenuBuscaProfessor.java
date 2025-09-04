package org.example.view;

import org.example.controller.RemoverProfessor;
import org.example.model.Escola;
import org.example.model.Professor;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe responsável por exibir o menu de gerenciamento de professores.
 * <p>
 * Permite ao usuário ler informações de um professor, atualizar seus dados ou deletá-lo.
 * O professor é buscado pelo nome.
 * </p>
 *
 * Autor: Henrick
 * Versão: 1.0
 */
public class MenuBuscaProfessor {
    Scanner sc = new Scanner(System.in);

    /**
     * Exibe o menu de gerenciamento de professores.
     * <p>
     * As opções disponíveis são:
     * <ul>
     *     <li>0 - Ler informações do professor</li>
     *     <li>1 - Atualizar dados do professor</li>
     *     <li>2 - Deletar professor</li>
     *     <li>3 - Voltar ao menu anterior</li>
     * </ul>
     *
     * @param escola Escola cujos professores serão gerenciados
     */
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

    /**
     * Busca um professor pelo nome nas listas de professores da escola.
     *
     * @param escola Escola cujos professores serão pesquisados
     * @param nome Nome do professor a ser buscado
     * @return O objeto Professor correspondente ao nome, ou null se não encontrado
     */
    private Professor buscarProfessorPorNome(Escola escola, String nome) {
        for (Professor p : escola.getProfessoresGeral()) {
            if (p.getNome().trim().equalsIgnoreCase(nome.trim())) {
                return p;
            }
        }
        return null;
    }

}




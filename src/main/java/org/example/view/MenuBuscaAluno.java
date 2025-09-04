package org.example.view;

import org.example.controller.RemoverAluno;
import org.example.model.Aluno;
import org.example.model.Escola;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe responsável por exibir o menu de gerenciamento de alunos.
 * <p>
 * Permite ao usuário ler informações de um aluno, atualizar seus dados ou deletá-lo.
 * O aluno é buscado pelo nome.
 * </p>
 *
 * Autor: Henrick
 * Versão: 1.0
 */
public class MenuBuscaAluno {
    Scanner sc = new Scanner(System.in);

    /**
     * Exibe o menu de gerenciamento de alunos.
     * <p>
     * As opções disponíveis são:
     * <ul>
     *     <li>0 - Ler informações do aluno</li>
     *     <li>1 - Atualizar dados do aluno</li>
     *     <li>2 - Deletar aluno</li>
     *     <li>3 - Voltar ao menu anterior</li>
     * </ul>
     *
     * @param escola Escola cujos alunos serão gerenciados
     */
    public void ExibirMenuAluno(Escola escola) {
        try {
            System.out.println("\n====================================");
            System.out.println("            Gerenciar Aluno          ");
            System.out.println("====================================\n");

            System.out.println("[0] Ler informações");
            System.out.println("[1] Atualizar");
            System.out.println("[2] Deletar");
            System.out.println("[3] Voltar");
            System.out.print("\nOpção: ");

            int acao = sc.nextInt();
            sc.nextLine();

            System.out.print("\nDigite o nome do aluno: ");
            String nome = sc.nextLine().trim();

            Aluno buscado = buscarAlunoPorNome(escola, nome);

            if (buscado == null) {
                System.out.println("\n❌ Não há aluno com esse nome cadastrado.");
            } else {
                switch (acao) {
                    case 0:
                        System.out.println("\n--- Informações do Aluno ---");
                        System.out.println("Nome: " + buscado.getNome());
                        System.out.println("Data de Nascimento: " + buscado.getDataNascimento());
                        System.out.println("Endereço: " + buscado.getEndereco().bairro + " - " + buscado.getEndereco().estado);
                        System.out.println("Naturalidade: " + buscado.getNaturalidade());
                        if (buscado.getResponsavel() != null) {
                            System.out.println("Responsável: " + buscado.getResponsavel().getNome());
                        } else {
                            System.out.println("Responsável: Sem responsável cadastrado.");
                        }
                        if (buscado.getTurma() != null) {
                            System.out.println("Turma: " + buscado.getTurma().getSerie() + " - " + buscado.getTurma().getAnoLetivo());
                        } else {
                            System.out.println("Turma: Sem turma atribuída.");
                        }
                        break;
                    case 1:
                        AtualizarAluno atualizarAluno = new AtualizarAluno();
                        atualizarAluno.AtualizarAluno(escola, buscado);
                        break;
                    case 2:
                        RemoverAluno removerAluno = new RemoverAluno();
                        removerAluno.RemoverAluno(escola, buscado);
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
     * Busca um aluno pelo nome na lista de alunos da escola.
     *
     * @param escola Escola cujos alunos serão pesquisados
     * @param nome Nome do aluno a ser buscado
     * @return O objeto Aluno correspondente ao nome, ou null se não encontrado
     */
    private Aluno buscarAlunoPorNome(Escola escola, String nome) {
        if (escola.getAlunos() != null) {
            for (Aluno a : escola.getAlunos()) {
                if (a.getNome().equalsIgnoreCase(nome)) return a;
            }
        }
        return null;
    }
}





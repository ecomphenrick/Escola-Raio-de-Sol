package org.example.view;

import org.example.model.Escola;
import org.example.model.Turma;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por atualizar os dados de uma turma na escola.
 * <p>
 * Permite editar informações como série e ano letivo.
 * Informações de alunos e professor são exibidas, mas para alterações específicas,
 * deve-se utilizar os menus de Alunos e Professores.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class AtualizarTurma {
    Scanner sc = new Scanner(System.in);

    /**
     * Atualiza os dados de uma turma específica da escola.
     * <p>
     * O usuário escolhe qual campo deseja alterar através de um menu interativo:
     * <ul>
     *     <li>0 - Série</li>
     *     <li>1 - Ano Letivo</li>
     *     <li>2 - Alunos (exibe a lista, não altera)</li>
     *     <li>3 - Professor (exibe o professor, alterações devem ser feitas pelo menu de Professores)</li>
     * </ul>
     * Caso a opção escolhida seja inválida, o método encerra a edição.
     * </p>
     *
     * @param escola Escola em que a turma está vinculada
     * @param turma Turma cujos dados serão atualizados
     */
    public void AtualizaTurma(Escola escola, Turma turma) {
        try {
            System.out.println("O que você deseja atualizar? ");
            System.out.println("0 - Série");
            System.out.println("1 - Ano Letivo");
            System.out.println("2 - Alunos");
            System.out.println("3 - Professor");
            System.out.println("Outra tecla para sair... ");

            int acao = sc.nextInt();
            sc.nextLine();

            switch (acao) {
                case 0:
                    System.out.print("Corrija a série: ");
                    int novaSerie = sc.nextInt();
                    sc.nextLine();
                    if (novaSerie < 1 || novaSerie > 5) {
                        System.out.println("❌ Série inválida. Deve ser de 1 a 5.");
                    } else {
                        turma.setSerie(novaSerie);
                        System.out.println("✅ Série atualizada com sucesso.");
                    }
                    break;

                case 1:
                    System.out.print("Corrija o ano letivo: ");
                    int novoAno = sc.nextInt();
                    sc.nextLine();
                    turma.setAnoLetivo(novoAno);
                    System.out.println("✅ Ano letivo atualizado com sucesso.");
                    break;

                case 2:
                    List alunos = turma.getAlunos();
                    if (alunos == null || alunos.isEmpty()) {
                        System.out.println("❌ Não há alunos nesta turma.");
                    } else {
                        System.out.println("Alunos da turma:");
                        for (int i = 0; i < alunos.size(); i++) {
                            System.out.println(i + " - " + alunos.get(i).toString());
                        }
                        System.out.println("⚠ Para alterações específicas de alunos, utilize o menu de Alunos.");
                    }
                    break;

                case 3:
                    if (turma.getProfessor() != null) {
                        System.out.println("Professor atual: " + turma.getProfessor().getNome());
                        System.out.println("⚠ Para alterar o professor, utilize o menu de Professores.");
                    } else {
                        System.out.println("Sem professor atribuído. Use o menu de Professores para vincular.");
                    }
                    break;

                default:
                    System.out.println("Saindo...");
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("❌ Entrada inválida. Digite apenas números para a opção.");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("❌ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}



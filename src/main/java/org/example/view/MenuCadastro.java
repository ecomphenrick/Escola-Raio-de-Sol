package org.example.view;

import org.example.model.Escola;
import java.util.Scanner;

/**
 * Classe responsável por exibir o menu de cadastro na aplicação.
 * <p>
 * Permite ao usuário cadastrar Alunos, Professores e Turmas.
 * Cada opção redireciona para a classe de cadastro correspondente.
 * </p>
 *
 * Autor: Henrick
 * Versão: 1.0
 */
public class MenuCadastro {
    Scanner sc = new Scanner(System.in);

    /**
     * Exibe o menu de cadastro e permite a escolha das ações.
     * <p>
     * As opções disponíveis são:
     * <ul>
     *     <li>0 - Cadastrar Aluno (é necessário que haja turmas cadastradas)</li>
     *     <li>1 - Cadastrar Professor</li>
     *     <li>2 - Cadastrar Turma</li>
     *     <li>3 - Voltar ao menu principal</li>
     * </ul>
     *
     * @param escola Escola onde os cadastros serão realizados
     */
    public void ExibirMenu(Escola escola) {
        int acaoCadastro = -1;

        do {
            System.out.println("\n====================================");
            System.out.println("             Cadastro               ");
            System.out.println("====================================\n");

            System.out.println("Escolha uma ação:");
            System.out.println("[0] Cadastrar Aluno");
            System.out.println("[1] Cadastrar Professor");
            System.out.println("[2] Cadastrar Turma");
            System.out.println("[3] Voltar ao menu principal");
            System.out.print("\nOpção: ");

            try {
                acaoCadastro = sc.nextInt();
            } catch (Exception e) {
                System.out.println("\n❌ Entrada inválida! Digite apenas números.");
                sc.nextLine();
                continue;
            }

            sc.nextLine();
            System.out.println();

            switch (acaoCadastro) {
                case 0:
                    if (escola.getTurmas() == null || escola.getTurmas().isEmpty()) {
                        System.out.println("⚠️ Não há turmas cadastradas. Cadastre uma antes.");
                    } else {
                        CadastroAluno cadastroAluno = new CadastroAluno();
                        cadastroAluno.CadastroAluno(escola);
                    }
                    break;
                case 1:
                    CadastroProfessor cadastroProfessor = new CadastroProfessor();
                    cadastroProfessor.CadastroProfessor(escola);
                    break;
                case 2:
                    CadastroTurma cadastroTurma = new CadastroTurma();
                    cadastroTurma.CadastroTurma(escola);
                    break;
                case 3:
                    System.out.println("🔙 Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("⚠️ Opção inválida. Tente novamente.");
                    break;
            }

        } while (acaoCadastro != 3);
    }
}




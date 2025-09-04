package org.example;

import org.example.controller.AtualizaAno;
import org.example.model.Escola;
import org.example.view.MenuBusca;
import org.example.view.MenuCadastro;

import java.util.Scanner;

/**
 * Classe principal do sistema Escola Raio de Sol.
 * <p>
 * Fornece um menu principal com as opções de:
 * <ul>
 *     <li>Cadastro de Alunos, Professores e Turmas</li>
 *     <li>Busca e gerenciamento de registros</li>
 *     <li>Atualização do ano das turmas</li>
 *     <li>Sair do sistema</li>
 * </ul>
 * </p>
 *
 * Autor: Henrick
 * Versão: 1.0
 */
public class Main {

    /**
     * Ponto de entrada da aplicação.
     * <p>
     * Inicializa a escola, exibe o menu principal e gerencia a interação do usuário.
     * </p>
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Escola escola = new Escola();
        int acao = -1;

        do {
            System.out.println("\n====================================");
            System.out.println("     Bem-vindo à Escola Raio de Sol!");
            System.out.println("====================================\n");

            System.out.println("Escolha uma opção:");
            System.out.println("[0] - Cadastro");
            System.out.println("[1] - Busca");
            System.out.println("[2] - Atualizar Ano");
            System.out.println("[3] - Sair");
            System.out.print("\nDigite sua escolha: ");

            try {
                acao = sc.nextInt();
            } catch (Exception e) {
                System.out.println("\n❌ Entrada inválida! Digite apenas números.");
                sc.nextLine();
                continue;
            }

            System.out.println();

            switch (acao) {
                case 0:
                    MenuCadastro menuCadastro = new MenuCadastro();
                    menuCadastro.ExibirMenu(escola);
                    break;
                case 1:
                    MenuBusca menuBusca = new MenuBusca();
                    menuBusca.ExibirMenu(escola);
                    break;
                case 2:
                    AtualizaAno atualizaAno = new AtualizaAno();
                    atualizaAno.atualizarAno(escola);
                    break;
                case 3:
                    System.out.println("👋 Obrigado por usar o sistema! Até logo!");
                    break;
                default:
                    System.out.println("⚠️ Opção inválida, selecione outra!");
                    break;
            }

        } while (acao != 3);
    }
}




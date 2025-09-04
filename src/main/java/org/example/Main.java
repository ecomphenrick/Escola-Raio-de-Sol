package org.example;

import org.example.controller.AtualizaAno;
import org.example.model.Escola;
import org.example.view.MenuBusca;
import org.example.view.MenuCadastro;
/*******************************************************************************
 Autor: Henrick Ferreira
 Componente Curricular: MI - Programação
 Concluido em: 04/09/2025
 Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
 trecho de código de outro colega ou de outro autor, tais como provindos de livros e
 apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 ******************************************************************************************/

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




package org.example;

import org.example.*;
import org.example.controller.AtualizaAno;
import org.example.model.Escola;
import org.example.view.MenuBusca;
import org.example.view.MenuCadastro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Escola escola = new Escola();
        int acao = -1;

        do {
            System.out.println("Bem vindos a Escola Raio de Sol!");
            System.out.println("0 - Cadastro");
            System.out.println("1 - Busca");
            System.out.println("2 - Atualizar Ano"); //Ver como implementar.
            System.out.println("3 - Sair");

            try {
                acao = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite apenas números.");
                sc.nextLine(); // limpa o buffer para evitar loop infinito
                continue; // volta para o começo do loop
            }

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
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida, selecione outra!");
                    break;
            }

        } while (acao != 3);
    }
}


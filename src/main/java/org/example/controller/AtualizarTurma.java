package org.example.controller;

import org.example.model.Escola;
import org.example.model.Turma;

import java.util.Scanner;

public class AtualizarTurma {
    Scanner sc = new Scanner(System.in);
    public void AtualizaTurma(Escola escola, Turma turma){
        System.out.println("O que você deseja atualizar? ");
        System.out.println("0 - Série");
        System.out.println("1 - Ano Letivo");
        System.out.println("2 - Alunos");
        System.out.println("3 - Professor");
        System.out.println("Nada... ");
        int acao = sc.nextInt();
        sc.nextLine();
        switch (acao){
            case 1:
                System.out.println("Corrija a série: ");
                int novaSerie = sc.nextInt();
                sc.nextLine();
                turma.setSerie(novaSerie);
                break;
            case 2:
                System.out.println("Corrija o ano letivo: ");
                int novoAno = sc.nextInt();
                sc.nextLine();
                turma.setAnoLetivo(novoAno);
            case 3:
                //Deus sabe como implementa
                break;
            case 4:
                //Tem que ver com os cara la.
                break;
            default:
                System.out.println("Saindo... ");
                break;

        }

    }
}

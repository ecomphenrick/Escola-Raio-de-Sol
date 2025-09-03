package org.example.view;


import org.example.model.Aluno;
import org.example.model.Escola;
import org.example.model.Turma;

import java.util.List;
import java.util.Scanner;

public class MenuBuscaTurma {
    Scanner sc = new Scanner(System.in);

    public void ExibirMenuTurma(Escola escola) {
        List<Turma> turmas = escola.getTurmas();
        System.out.println("0 - Ler");
        System.out.println("1 - Atualizar");
        System.out.println("2 - Deletar");
        System.out.println("3 - Sair");
        int acaoTurma = sc.nextInt();
        sc.nextLine();
        System.out.println("Em qual turma? ");
        for (int i = 0; i < turmas.size(); i++) {
            Turma t = turmas.get(i);
            System.out.println(i + ": " + t.getSerie() + " - " + t.getAnoLetivo());
        }
        System.out.println("Escolha a turma: ");
        int escolhaTurma = sc.nextInt();
        sc.nextLine();
        Turma turmaEscolhida = turmas.get(escolhaTurma);
        switch (acaoTurma) {
            case 0:
                System.out.println("Turma: " + turmaEscolhida.getSerie() + " - " + turmaEscolhida.getAnoLetivo());
                System.out.println("Professor: " + turmaEscolhida.getProfessor().getNome());
                System.out.println("Alunos: ");
                List<Aluno> alunos = turmaEscolhida.getAlunos();
                for(Aluno aluno : alunos){
                    System.out.println("Nome: " + aluno.getNome());
                }
                break;
            case 1:
                //Ver como Implementar
                break;
            case 2:
                escola.getTurmas().remove(turmaEscolhida);
                break;
            case 3:
                System.out.println("Saindo... ");
                break;
        }
    }
}

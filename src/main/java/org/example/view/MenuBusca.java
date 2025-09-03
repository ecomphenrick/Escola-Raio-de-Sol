package org.example.view;

import org.example.model.Escola;

import java.util.Scanner;

public class MenuBusca {
    Scanner sc = new Scanner(System.in);
    public void ExibirMenu(Escola escola) {
        int acao;
        do {
            System.out.println("Busca\n");
            System.out.println("Você deseja buscar: ");
            System.out.println("0 - Aluno");
            System.out.println("1 - Professor");
            System.out.println("2 - Turma");
            System.out.println("3 - Sair");
            acao = sc.nextInt();
            sc.nextLine();
            switch (acao) {
                case 0:
                    if(escola.getAlunos()==null || escola.getAlunos().isEmpty()){
                        System.out.println("Não há alunos cadastrados.");
                    }else{
                        MenuBuscaAluno menuBuscaAluno = new MenuBuscaAluno();
                        menuBuscaAluno.ExibirMenuAluno(escola);
                    }
                    break;

                case 1:
                    if(escola.getProfessoresGeral()==null|| escola.getProfessoresGeral().isEmpty()){
                        System.out.println("Não há professores cadastrados. ");
                    }else{
                        MenuBuscaProfessor menuBuscaProfessor = new MenuBuscaProfessor();
                        menuBuscaProfessor.ExibirMenuProfessor(escola);
                    }
                    break;
                case 2:
                    if(escola.getTurmas()==null || escola.getTurmas().isEmpty()){
                        System.out.println("Não existem turmas cadastradas.");
                    }else{
                        MenuBuscaTurma menuBuscaTurma = new MenuBuscaTurma();
                        menuBuscaTurma.ExibirMenuTurma(escola);
                    }
                    break;
                case 3:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção Inválida. ");
                    break;

            }
        } while (acao != 3);
    }
}
package org.example.view;

import org.example.model.Escola;

import java.util.Scanner;

public class MenuCadastro {
    Scanner sc = new Scanner(System.in);
    public void ExibirMenu(Escola escola) {
        int acaoCadastro = -1;
        do {
            System.out.println("Cadastro.\n");
            System.out.println("Digite a opção desejada: ");
            System.out.println("0 - Cadastrar Aluno");
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Turma");
            System.out.println("3 - Sair");
            try {
                acaoCadastro = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite apenas números.");
                sc.nextLine();
                continue;
            }
            sc.nextLine();
            switch (acaoCadastro) {
                case 0:

                    if (escola.getTurmas() == null || escola.getTurmas().isEmpty()) { //Verifica se existem turmas cadastradas.
                        System.out.println("Não há turmas cadastradas, cadastre uma antes.");
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
                    System.out.println("Sair.");
                    break;
                default:
                    System.out.println("Opção inválida, selecione outra.");
                    break;
            }
        } while (acaoCadastro != 3);
    }
}



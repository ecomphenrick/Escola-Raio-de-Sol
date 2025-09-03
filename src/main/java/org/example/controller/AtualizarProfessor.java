package org.example.controller;


import org.example.model.Endereco;
import org.example.model.Escola;
import org.example.model.Professor;
import org.example.model.Turma;

import java.util.List;
import java.util.Scanner;

public class AtualizarProfessor {
    Scanner sc = new Scanner(System.in);
    public void AtualizarProfessor(Escola escola, Professor professor){
        System.out.println("O que você deseja editar: ");
        System.out.println("0 - Nome");
        System.out.println("1 - Data de Nascimento");
        System.out.println("2 - Endereço");
        System.out.println("3 - Formação");
        System.out.println("4 - Turma");
        System.out.println("5 - Telefone");
        System.out.println("6 - Dependentes");
        System.out.println("Outra tecla para sair... ");
        int acao = sc.nextInt();
        sc.nextLine();

        switch (acao) {
            case 0:
                System.out.println("Corrija o nome: ");
                String novoNome = sc.nextLine();
                professor.setNome(novoNome);
                break;

            case 1:
                System.out.println("Corrija a data de nascimento: ");
                String novaData = sc.nextLine();
                professor.setDataNascimento(novaData);
                break;

            case 2:
                System.out.println("Corrija o endereço: ");
                System.out.println("Rua: ");
                String rua = sc.nextLine();
                System.out.println("Bairro: ");
                String bairro = sc.nextLine();
                System.out.println("CEP: ");
                String cep = sc.nextLine();
                System.out.println("Cidade: ");
                String cidade = sc.nextLine();
                System.out.println("Estado: ");
                String estado = sc.nextLine();
                Endereco endereco = new Endereco(rua, bairro, cep, cidade, estado);
                professor.setEndereco(endereco);
                break;
            case 3:
                System.out.println("Corrija a formação: ");
                String novaFormacao = sc.nextLine();
                professor.setFormacao(novaFormacao);
                break;

            case 4:
                System.out.println("Corrija a turma: ");
                if (professor.getTurma() != null) {
                    professor.getTurma().setProfessor(null);
                }

                List<Turma> turmas = escola.getTurmas();
                for (int i = 0; i < turmas.size(); i++) {
                    System.out.println(i + " - " + turmas.get(i).getSerie() + " - " + turmas.get(i).getAnoLetivo());
                }

                System.out.println("Escolha a nova turma: ");
                int turmaIndice = sc.nextInt();
                sc.nextLine();

                Turma novaTurma = turmas.get(turmaIndice);
                novaTurma.setProfessor(professor);
                professor.setTurma(novaTurma);
                break;

            case 5:
                System.out.println("Corrija o telefone: ");
                String novoTelefone = sc.nextLine();
                professor.setTelefone(novoTelefone);
                break;

            default:
                System.out.println("Saindo da edição...");
                break;
        }

    }
}

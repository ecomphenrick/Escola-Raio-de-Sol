package org.example.controller;

import org.example.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtualizarAluno {
    Scanner sc = new Scanner(System.in);
    public void AtualizarAluno(Escola escola, Aluno aluno){
        System.out.println("O que você deseja editar: ");
        System.out.println("0 - Nome");
        System.out.println("1 - Data de Nascimento");
        System.out.println("2 - Endereço");
        System.out.println("3 - Naturalidade");
        System.out.println("4 - Responsável");
        System.out.println("5 - Turma");
        System.out.println("Outra tecla para sair... ");
        int acao = sc.nextInt();
        sc.nextLine();

        switch (acao) {
            case 0:
                System.out.println("Digite o novo nome: ");
                String novoNome = sc.nextLine();
                aluno.setNome(novoNome);
                break;

            case 1:
                System.out.println("Digite a nova data de nascimento: ");
                String novaData = sc.nextLine();
                aluno.setDataNascimento(novaData);
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
                aluno.setEndereco(endereco);
                break;

            case 3:
                System.out.println("Digite a nova naturalidade: ");
                String novaNaturalidade = sc.nextLine();
                aluno.setNaturalidade(novaNaturalidade);
                break;

            case 4:
                System.out.println("Corrija o responsável: ");
                System.out.println("Nome Responsável: ");
                String nomeResp = sc.nextLine();
                System.out.println("Data de Nascimento Responsável: ");
                String dataResp = sc.nextLine();
                System.out.println("Telefone: ");
                String telefone = sc.nextLine();
                List<Aluno> dependentes = new ArrayList<>();
                Responsavel responsavel = new Responsavel(nomeResp, dataResp, aluno.getEndereco(), telefone, dependentes);
                aluno.setResponsavel(responsavel);
                break;

            case 5:
                System.out.println("Corrija a turma: ");
                aluno.getTurma().getAlunos().remove(aluno);
                List<Turma> turmas = escola.getTurmas();
                for (int i = 0; i < turmas.size(); i++) {
                    System.out.println(i + " - " + turmas.get(i).getSerie() + " - " + turmas.get(i).getAnoLetivo());
                }
                int novaTurmaIndice = sc.nextInt();
                sc.nextLine();
                Turma novaTurma = turmas.get(novaTurmaIndice);

                novaTurma.getAlunos().add(aluno);
                aluno.setTurma(novaTurma);

                //Não sei como implementar...
                break;

            default:
                System.out.println("Saindo da edição...");
                break;
        }



    }
}

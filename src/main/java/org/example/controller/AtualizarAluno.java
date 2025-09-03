package org.example.controller;

import org.example.model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AtualizarAluno {
    Scanner sc = new Scanner(System.in);

    public void AtualizarAluno(Escola escola, Aluno aluno) {
        try {
            System.out.println("O que você deseja editar: ");
            System.out.println("0 - Nome");
            System.out.println("1 - Data de Nascimento");
            System.out.println("2 - Endereço");
            System.out.println("3 - Naturalidade");
            System.out.println("4 - Responsável");
            System.out.println("5 - Turma");
            System.out.println("Outra tecla para sair... ");

            int acao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (acao) {
                case 0:
                    System.out.print("Digite o novo nome: ");
                    String novoNome = sc.nextLine();
                    aluno.setNome(novoNome);
                    System.out.println("✅ Nome atualizado com sucesso.");
                    break;

                case 1:
                    System.out.print("Digite a nova data de nascimento: ");
                    String novaData = sc.nextLine();
                    aluno.setDataNascimento(novaData);
                    System.out.println("✅ Data de nascimento atualizada com sucesso.");
                    break;

                case 2:
                    System.out.println("Corrija o endereço: ");
                    System.out.print("Rua: ");
                    String rua = sc.nextLine();
                    System.out.print("Bairro: ");
                    String bairro = sc.nextLine();
                    System.out.print("CEP: ");
                    String cep = sc.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = sc.nextLine();
                    System.out.print("Estado: ");
                    String estado = sc.nextLine();
                    Endereco endereco = new Endereco(rua, bairro, cep, cidade, estado);
                    aluno.setEndereco(endereco);
                    System.out.println("✅ Endereço atualizado com sucesso.");
                    break;

                case 3:
                    System.out.print("Digite a nova naturalidade: ");
                    String novaNaturalidade = sc.nextLine();
                    aluno.setNaturalidade(novaNaturalidade);
                    System.out.println("✅ Naturalidade atualizada com sucesso.");
                    break;

                case 4:
                    System.out.println("Corrija o responsável: ");
                    System.out.print("Nome Responsável: ");
                    String nomeResp = sc.nextLine();
                    System.out.print("Data de Nascimento Responsável: ");
                    String dataResp = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    List<Aluno> dependentes = new ArrayList<>();
                    Responsavel responsavel = new Responsavel(nomeResp, dataResp, aluno.getEndereco(), telefone, dependentes);
                    aluno.setResponsavel(responsavel);
                    System.out.println("✅ Responsável atualizado com sucesso.");
                    break;

                case 5:
                    System.out.println("Corrija a turma: ");
                    // Remove aluno da turma atual, se houver
                    if (aluno.getTurma() != null) {
                        aluno.getTurma().getAlunos().remove(aluno);
                    }

                    List<Turma> turmas = escola.getTurmas();
                    for (int i = 0; i < turmas.size(); i++) {
                        System.out.println(i + " - " + turmas.get(i).getSerie() + " - " + turmas.get(i).getAnoLetivo());
                    }

                    System.out.print("Escolha a nova turma: ");
                    int novaTurmaIndice = sc.nextInt();
                    sc.nextLine(); // limpar buffer

                    if (novaTurmaIndice < 0 || novaTurmaIndice >= turmas.size()) {
                        System.out.println("❌ Índice inválido. Turma não alterada.");
                    } else {
                        Turma novaTurma = turmas.get(novaTurmaIndice);
                        novaTurma.getAlunos().add(aluno);
                        aluno.setTurma(novaTurma);
                        System.out.println("✅ Turma atualizada com sucesso.");
                    }
                    break;

                default:
                    System.out.println("Saindo da edição...");
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("❌ Entrada inválida. Digite apenas números para a opção.");
            sc.nextLine(); // limpar buffer
        } catch (Exception e) {
            System.out.println("❌ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}

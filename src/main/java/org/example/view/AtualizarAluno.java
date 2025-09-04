package org.example.view;

import org.example.model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por atualizar os dados de um aluno na escola.
 * <p>
 * Permite editar informações como nome, data de nascimento, endereço, naturalidade,
 * responsável e turma do aluno.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class AtualizarAluno {
    Scanner sc = new Scanner(System.in);

    /**
     * Atualiza os dados de um aluno específico da escola.
     * <p>
     * O usuário escolhe qual campo deseja alterar através de um menu interativo:
     * <ul>
     *     <li>0 - Nome</li>
     *     <li>1 - Data de Nascimento</li>
     *     <li>2 - Endereço</li>
     *     <li>3 - Naturalidade</li>
     *     <li>4 - Responsável</li>
     *     <li>5 - Turma</li>
     * </ul>
     * Caso a opção escolhida seja inválida, o método encerra a edição.
     * </p>
     *
     * @param escola Escola em que o aluno está matriculado
     * @param aluno Aluno cujos dados serão atualizados
     */
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
            sc.nextLine();

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
                    if (aluno.getTurma() != null) {
                        aluno.getTurma().getAlunos().remove(aluno);
                    }

                    List<Turma> turmas = escola.getTurmas();
                    for (int i = 0; i < turmas.size(); i++) {
                        System.out.println(i + " - " + turmas.get(i).getSerie() + " - " + turmas.get(i).getAnoLetivo());
                    }

                    System.out.print("Escolha a nova turma: ");
                    int novaTurmaIndice = sc.nextInt();
                    sc.nextLine();

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
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("❌ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}


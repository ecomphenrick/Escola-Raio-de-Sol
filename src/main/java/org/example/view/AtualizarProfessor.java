package org.example.view;

import org.example.model.Endereco;
import org.example.model.Escola;
import org.example.model.Professor;
import org.example.model.Turma;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por atualizar os dados de um professor na escola.
 * <p>
 * Permite editar informações como nome, data de nascimento, endereço, formação,
 * turma e telefone do professor.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class AtualizarProfessor {
    Scanner sc = new Scanner(System.in);

    /**
     * Atualiza os dados de um professor específico da escola.
     * <p>
     * O usuário escolhe qual campo deseja alterar através de um menu interativo:
     * <ul>
     *     <li>0 - Nome</li>
     *     <li>1 - Data de Nascimento</li>
     *     <li>2 - Endereço</li>
     *     <li>3 - Formação</li>
     *     <li>4 - Turma</li>
     *     <li>5 - Telefone</li>
     * </ul>
     * Caso a opção escolhida seja inválida, o método encerra a edição.
     * </p>
     *
     * @param escola Escola em que o professor está vinculado
     * @param professor Professor cujos dados serão atualizados
     */
    public void AtualizarProfessor(Escola escola, Professor professor) {
        try {
            System.out.println("O que você deseja editar: ");
            System.out.println("0 - Nome");
            System.out.println("1 - Data de Nascimento");
            System.out.println("2 - Endereço");
            System.out.println("3 - Formação");
            System.out.println("4 - Turma");
            System.out.println("5 - Telefone");
            System.out.println("Outra tecla para sair... ");

            int acao = sc.nextInt();
            sc.nextLine();

            switch (acao) {
                case 0:
                    System.out.print("Corrija o nome: ");
                    String novoNome = sc.nextLine();
                    professor.setNome(novoNome);
                    System.out.println("✅ Nome atualizado com sucesso.");
                    break;

                case 1:
                    System.out.print("Corrija a data de nascimento: ");
                    String novaData = sc.nextLine();
                    professor.setDataNascimento(novaData);
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
                    professor.setEndereco(endereco);
                    System.out.println("✅ Endereço atualizado com sucesso.");
                    break;

                case 3:
                    System.out.print("Corrija a formação: ");
                    String novaFormacao = sc.nextLine();
                    professor.setFormacao(novaFormacao);
                    System.out.println("✅ Formação atualizada com sucesso.");
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

                    System.out.print("Escolha a nova turma: ");
                    int turmaIndice = sc.nextInt();
                    sc.nextLine();

                    if (turmaIndice < 0 || turmaIndice >= turmas.size()) {
                        System.out.println("❌ Índice inválido. Turma não alterada.");
                    } else {
                        Turma novaTurma = turmas.get(turmaIndice);
                        novaTurma.setProfessor(professor);
                        professor.setTurma(novaTurma);
                        System.out.println("✅ Turma atualizada com sucesso.");
                    }
                    break;

                case 5:
                    System.out.print("Corrija o telefone: ");
                    String novoTelefone = sc.nextLine();
                    professor.setTelefone(novoTelefone);
                    System.out.println("✅ Telefone atualizado com sucesso.");
                    break;

                default:
                    System.out.println("Saindo da edição...");
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("❌ Entrada inválida. Digite apenas números para a opção.");
            sc.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("❌ Índice de turma inválido. Operação cancelada.");
        } catch (Exception e) {
            System.out.println("❌ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}





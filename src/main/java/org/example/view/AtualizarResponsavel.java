package org.example.view;

import org.example.model.Escola;
import org.example.model.Responsavel;
import org.example.model.Endereco;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe responsável por atualizar os dados de um responsável na escola.
 * <p>
 * Permite editar informações como nome, data de nascimento, endereço e telefone do responsável.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class AtualizarResponsavel {
    Scanner sc = new Scanner(System.in);

    /**
     * Atualiza os dados de um responsável específico da escola.
     * <p>
     * O usuário escolhe qual campo deseja alterar através de um menu interativo:
     * <ul>
     *     <li>0 - Nome</li>
     *     <li>1 - Data de Nascimento</li>
     *     <li>2 - Endereço</li>
     *     <li>3 - Telefone</li>
     * </ul>
     * Caso a opção escolhida seja inválida, o método encerra a edição.
     * </p>
     *
     * @param escola Escola em que o responsável está vinculado
     * @param responsavel Responsável cujos dados serão atualizados
     */
    public void AtualizarResponsavel(Escola escola, Responsavel responsavel) {
        try {
            System.out.println("O que você deseja editar: ");
            System.out.println("0 - Nome");
            System.out.println("1 - Data de Nascimento");
            System.out.println("2 - Endereço");
            System.out.println("3 - Telefone");
            System.out.println("Outra tecla para sair...");

            int acao = sc.nextInt();
            sc.nextLine();

            switch (acao) {
                case 0:
                    System.out.print("Corrija o nome: ");
                    String novoNome = sc.nextLine();
                    responsavel.setNome(novoNome);
                    System.out.println("✅ Nome atualizado com sucesso.");
                    break;

                case 1:
                    System.out.print("Corrija a data de nascimento: ");
                    String novaData = sc.nextLine();
                    responsavel.setDataNascimento(novaData);
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
                    responsavel.setEndereco(endereco);
                    System.out.println("✅ Endereço atualizado com sucesso.");
                    break;

                case 3:
                    System.out.print("Corrija o telefone: ");
                    String novoTelefone = sc.nextLine();
                    responsavel.setTelefone(novoTelefone);
                    System.out.println("✅ Telefone atualizado com sucesso.");
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



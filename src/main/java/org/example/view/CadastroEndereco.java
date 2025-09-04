package org.example.view;

import org.example.model.Endereco;

import java.util.Scanner;

/**
 * Classe responsável pelo cadastro interativo de endereços.
 * <p>
 * Permite ao usuário informar rua, bairro, CEP, cidade e estado,
 * retornando um objeto {@link Endereco} com os dados fornecidos.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class CadastroEndereco {
    Scanner sc = new Scanner(System.in);

    /**
     * Executa o cadastro interativo de um endereço.
     * <p>
     * Solicita ao usuário informações sobre rua, bairro, CEP, cidade e estado,
     * cria um objeto {@link Endereco} e retorna-o.
     * </p>
     *
     * @return objeto {@link Endereco} preenchido com os dados informados pelo usuário
     */
    public Endereco CadastroEndereco() {
        System.out.println("\n====================================");
        System.out.println("          Cadastrando Endereço       ");
        System.out.println("====================================\n");

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

        System.out.println("\n✅ Endereço cadastrado com sucesso!\n");

        return endereco;
    }
}



package org.example.view;

import org.example.model.Endereco;

import java.util.Scanner;

public class CadastroEndereco {
    Scanner sc = new Scanner(System.in);
    public Endereco CadastroEndereco (){
        System.out.println("Cadastrando Endereço: ");
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
        return endereco;
    }
}

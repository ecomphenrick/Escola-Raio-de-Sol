package org.example.view;

import org.example.controller.ControleCadastroResponsavel;
import org.example.model.Aluno;
import org.example.model.Endereco;
import org.example.model.Escola;
import org.example.model.Responsavel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroResponsavel {
    Scanner sc = new Scanner(System.in);

    public Responsavel CadastroResponsavel(Escola escola, Endereco endereco) {
        System.out.println("\n====================================");
        System.out.println("        Cadastrando Responsável      ");
        System.out.println("====================================\n");

        System.out.print("Nome do responsável: ");
        String nomeResp = sc.nextLine();

        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
        String dataResp = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        List<Aluno> dependentes = new ArrayList<>();
        Responsavel responsavel = new Responsavel(nomeResp, dataResp, endereco, telefone, dependentes);

        ControleCadastroResponsavel controleCadastroResponsavel = new ControleCadastroResponsavel();
        controleCadastroResponsavel.ControleCadastroResponsavel(escola, nomeResp, dataResp, endereco, telefone);

        System.out.println("\n✅ Responsável cadastrado com sucesso!\n");

        return responsavel;
    }
}


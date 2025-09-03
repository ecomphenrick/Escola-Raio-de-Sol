package org.example.view;

import org.example.controller.Cadastro;
import org.example.controller.ControleCadastroResponsavel;
import org.example.model.Aluno;
import org.example.model.Endereco;
import org.example.model.Escola;
import org.example.model.Responsavel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroResponsavel {
    Scanner sc =new Scanner(System.in);
    Cadastro cadastro = new Cadastro();
    public Responsavel CadastroResponsavel(Escola escola, Endereco endereco){
        System.out.println("Cadastrando Responsável: ");
        System.out.print("Nome Responsável: ");
        String nomeResp = sc.nextLine();
        System.out.print("Data de Nascimento Responsável: ");
        String dataResp = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        List<Aluno> dependentes = new ArrayList<>();

        Responsavel responsavel = new Responsavel(nomeResp, dataResp, endereco, telefone, dependentes);
        ControleCadastroResponsavel controleCadastroResponsavel = new ControleCadastroResponsavel();
        controleCadastroResponsavel.ControleCadastroResponsavel(escola, nomeResp, dataResp, endereco, telefone);

        return responsavel;


    }
}

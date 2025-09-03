package org.example.view;


import org.example.controller.Cadastro;
import org.example.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroProfessor {
    public void CadastroProfessor(Escola escola){
        Scanner sc = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();
        List<Turma> turmas = escola.getTurmas();
        System.out.println("Cadastrando Professor.");
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Data de Nascimento: ");
        String dataNascimento = sc.nextLine();
        System.out.println("Cadastrando Endereço: ");
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
        System.out.println("Formação: ");
        String formacao = sc.nextLine();
        System.out.println("Telefone: ");
        String telefone = sc.nextLine();
        List<Aluno> dependentes = new ArrayList<>();

        Professor novoProfessor;


        if(escola.getTurmas()==null || escola.getTurmas().isEmpty()) {
            novoProfessor = cadastro.CadastroProfessor(escola, nome, dataNascimento, endereco, formacao, null, telefone, dependentes);
            escola.adicionarProfessorSemTurma(novoProfessor);
            System.out.println("Professor sem turma");
        }else {
            System.out.println("Qual Turma? ");

            for (int i = 0; i < turmas.size(); i++) {
                Turma t = turmas.get(i);
                String status = (t.getProfessor() == null) ? " [Sem professor]" : " [Já possui professor]";
                System.out.println(i + " - " + t.getSerie() + " - " + t.getAnoLetivo() + status);
            }

            int escolha = sc.nextInt();
            sc.nextLine();
            Turma turma = turmas.get(escolha);

            if (turma.getProfessor() != null) {
                System.out.println("❌ Esta turma já possui professor: " + turma.getProfessor().getNome());
                System.out.println("Cadastro cancelado.");
                escola.adicionarProfessorSemTurma(
                        cadastro.CadastroProfessor(escola, nome, dataNascimento, endereco, formacao, null, telefone, dependentes)
                );
            } else {
                novoProfessor = cadastro.CadastroProfessor(escola, nome, dataNascimento, endereco, formacao, turma, telefone, dependentes);
                turma.setProfessor(novoProfessor);
                System.out.println("✅ Professor vinculado à turma.");
            }
        }

    }
}

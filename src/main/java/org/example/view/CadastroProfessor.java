package org.example.view;

import org.example.controller.Cadastro;
import org.example.model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CadastroProfessor {

    public void CadastroProfessor(Escola escola) {
        Scanner sc = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();
        List<Turma> turmas = escola.getTurmas();

        try {
            System.out.println("Cadastrando Professor.");
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Data de Nascimento: ");
            String dataNascimento = sc.nextLine();

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

            System.out.print("Formação: ");
            String formacao = sc.nextLine();

            System.out.print("Telefone: ");
            String telefone = sc.nextLine();

            List<Aluno> dependentes = new ArrayList<>();
            Professor novoProfessor;

            if (turmas == null || turmas.isEmpty()) {
                novoProfessor = cadastro.CadastroProfessor(escola, nome, dataNascimento, endereco, formacao, null, telefone, dependentes);
                escola.adicionarProfessorSemTurma(novoProfessor);
                System.out.println("✅ Professor cadastrado sem turma.");
            } else {
                System.out.println("Qual Turma? ");
                for (int i = 0; i < turmas.size(); i++) {
                    Turma t = turmas.get(i);
                    String status = (t.getProfessor() == null) ? " [Sem professor]" : " [Já possui professor]";
                    System.out.println(i + " - " + t.getSerie() + " - " + t.getAnoLetivo() + status);
                }

                int escolha = sc.nextInt();
                sc.nextLine();

                if (escolha < 0 || escolha >= turmas.size()) {
                    System.out.println("❌ Escolha de turma inválida. Professor será cadastrado sem turma.");
                    novoProfessor = cadastro.CadastroProfessor(escola, nome, dataNascimento, endereco, formacao, null, telefone, dependentes);
                    escola.adicionarProfessorSemTurma(novoProfessor);
                } else {
                    Turma turma = turmas.get(escolha);

                    if (turma.getProfessor() != null) {
                        System.out.println("❌ Esta turma já possui professor: " + turma.getProfessor().getNome());
                        System.out.println("Professor cadastrado sem turma.");
                        novoProfessor = cadastro.CadastroProfessor(escola, nome, dataNascimento, endereco, formacao, null, telefone, dependentes);
                        escola.adicionarProfessorSemTurma(novoProfessor);
                    } else {
                        novoProfessor = cadastro.CadastroProfessor(escola, nome, dataNascimento, endereco, formacao, turma, telefone, dependentes);
                        turma.setProfessor(novoProfessor);
                        System.out.println("✅ Professor vinculado à turma.");
                    }
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("❌ Erro: Entrada inválida. Digite apenas números ao escolher a turma.");
        } catch (Exception e) {
            System.out.println("❌ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}


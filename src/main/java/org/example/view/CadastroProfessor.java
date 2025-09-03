package org.example.view;

import org.example.controller.Cadastro;
import org.example.controller.ControleCadastroProfessor;
import org.example.model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CadastroProfessor {

    public void CadastroProfessor(Escola escola) {
        ControleCadastroProfessor controleCadastroProfessor = new ControleCadastroProfessor();
        Scanner sc = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();
        List<Turma> turmas = escola.getTurmas();

        try {
            System.out.println("Cadastrando Professor.");
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Data de Nascimento: ");
            String dataNascimento = sc.nextLine();

            CadastroEndereco cadastroEndereco = new CadastroEndereco();
            Endereco endereco = cadastroEndereco.CadastroEndereco();

            System.out.print("Formação: ");
            String formacao = sc.nextLine();

            System.out.print("Telefone: ");
            String telefone = sc.nextLine();

            List<Aluno> dependentes = new ArrayList<>();
            Professor novoProfessor;

            if (turmas == null || turmas.isEmpty()) {
                novoProfessor = controleCadastroProfessor.CadastroProfessor(escola, nome, dataNascimento, endereco,
                        formacao, null, telefone, dependentes);
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
                    novoProfessor = controleCadastroProfessor.CadastroProfessor(escola, nome, dataNascimento, endereco,
                            formacao, null, telefone, dependentes);
                } else {
                    Turma turma = turmas.get(escolha);

                    if (turma.getProfessor() != null) {
                        System.out.println("❌ Esta turma já possui professor: " + turma.getProfessor().getNome());
                        System.out.println("Professor cadastrado sem turma.");
                        novoProfessor = controleCadastroProfessor.CadastroProfessor(escola, nome, dataNascimento, endereco,
                                formacao, null, telefone, dependentes);
                    } else {
                        novoProfessor = controleCadastroProfessor.CadastroProfessor(escola, nome, dataNascimento, endereco,
                                formacao, turma, telefone, dependentes);
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



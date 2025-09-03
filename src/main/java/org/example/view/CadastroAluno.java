package org.example.view;

import org.example.controller.Cadastro;
import org.example.model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CadastroAluno {

    public void CadastroAluno(Escola escola) {
        Scanner sc = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();
        List<Turma> turmas = escola.getTurmas();

        try {
            System.out.println("Cadastrando Aluno.");
            System.out.println("Digite o nome do aluno: ");
            String nomeAluno = sc.nextLine();

            System.out.println("Data de Nascimento: ");
            String dataNascimentoAluno = sc.nextLine();

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

            System.out.println("Digite a Naturalidade: ");
            String naturalidade = sc.nextLine();

            // Escolha da turma
            System.out.println("Qual Turma? ");
            for (int i = 0; i < turmas.size(); i++) {
                Turma t = turmas.get(i);
                System.out.println(i + " - " + t.getSerie() + " - " + t.getAnoLetivo());
            }

            int escolha = sc.nextInt();
            sc.nextLine(); // limpar buffer

            if (escolha < 0 || escolha >= turmas.size()) {
                throw new IndexOutOfBoundsException("Turma escolhida não existe.");
            }

            Turma turma = turmas.get(escolha);

            System.out.println("Cadastrando Responsável: ");
            System.out.print("Nome Responsável: ");
            String nomeResp = sc.nextLine();
            System.out.print("Data de Nascimento Responsável: ");
            String dataResp = sc.nextLine();
            System.out.print("Telefone: ");
            String telefone = sc.nextLine();
            List<Aluno> dependentes = new ArrayList<>();

            Responsavel responsavel = new Responsavel(nomeResp, dataResp, endereco, telefone, dependentes);

            cadastro.CadastroResponsavel(escola, nomeResp, dataResp, endereco, telefone);

            cadastro.CadastroAluno(escola, nomeAluno, dataNascimentoAluno, endereco, naturalidade, responsavel, turma);

            System.out.println("Aluno cadastrado com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de digitar números corretamente.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}

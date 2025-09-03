package org.example.view;

import org.example.controller.Cadastro;
import org.example.controller.ControleCadastroAluno;
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
            System.out.print("Digite o nome do aluno: ");
            String nomeAluno = sc.nextLine();

            System.out.print("Data de Nascimento: ");
            String dataNascimentoAluno = sc.nextLine();

            CadastroEndereco cadastroEndereco = new CadastroEndereco();
            Endereco endereco = cadastroEndereco.CadastroEndereco();

            System.out.print("Digite a Naturalidade: ");
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

            // Cadastro do responsável
            CadastroResponsavel cadastroResponsavel = new CadastroResponsavel();
            Responsavel responsavel = cadastroResponsavel.CadastroResponsavel(escola, endereco);

            // Verifica se já existe um responsável com o mesmo nome
            Responsavel responsavelExistente = null;
            if (escola.getResponsaveis() != null) {
                for (Responsavel r : escola.getResponsaveis()) {
                    if (r.getNome().equalsIgnoreCase(responsavel.getNome())) {
                        responsavelExistente = r;
                        break;
                    }
                }
            }

            if (responsavelExistente != null) {
                responsavel = responsavelExistente;
            } else {
                if (escola.getResponsaveis() == null) {
                    escola.setResponsaveis(new ArrayList<>());
                }
                escola.getResponsaveis().add(responsavel);
            }

            ControleCadastroAluno controleCadastroAluno = new ControleCadastroAluno();
            controleCadastroAluno.ControleCadastroAluno(escola, nomeAluno, dataNascimentoAluno, endereco, naturalidade, responsavel, turma);

            System.out.println("✅ Aluno cadastrado com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("❌ Erro: Entrada inválida. Certifique-se de digitar números corretamente.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("❌ Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}



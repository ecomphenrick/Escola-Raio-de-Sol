package org.example.view;

import org.example.controller.ControleCadastroAluno;
import org.example.model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pelo cadastro interativo de alunos na escola.
 * <p>
 * Permite cadastrar um aluno informando: nome, data de nascimento, endereço,
 * naturalidade, responsável e turma. O responsável é verificado para não duplicar
 * registros na escola. A turma é escolhida a partir da lista de turmas existentes.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class CadastroAluno {

    /**
     * Executa o cadastro interativo de um aluno.
     * <p>
     * O método solicita ao usuário informações do aluno e cria o objeto correspondente.
     * Também verifica se o responsável já existe na escola para evitar duplicidade.
     * Caso a turma escolhida seja inválida ou ocorra algum erro na entrada, mensagens
     * de erro apropriadas são exibidas.
     * </p>
     *
     * @param escola Escola na qual o aluno será cadastrado
     */
    public void CadastroAluno(Escola escola) {
        Scanner sc = new Scanner(System.in);
        List<Turma> turmas = escola.getTurmas();

        try {
            System.out.println("\n====================================");
            System.out.println("           Cadastrando Aluno        ");
            System.out.println("====================================\n");

            System.out.print("Nome do aluno: ");
            String nomeAluno = sc.nextLine();

            System.out.print("Data de Nascimento (dd/mm/aaaa): ");
            String dataNascimentoAluno = sc.nextLine();

            CadastroEndereco cadastroEndereco = new CadastroEndereco();
            Endereco endereco = cadastroEndereco.CadastroEndereco();

            System.out.print("Naturalidade: ");
            String naturalidade = sc.nextLine();

            System.out.println("\nEscolha a Turma:");
            for (int i = 0; i < turmas.size(); i++) {
                Turma t = turmas.get(i);
                System.out.println("[" + i + "] " + t.getSerie() + " - " + t.getAnoLetivo());
            }

            System.out.print("\nOpção: ");
            int escolha = sc.nextInt();
            sc.nextLine();

            if (escolha < 0 || escolha >= turmas.size()) {
                throw new IndexOutOfBoundsException("Turma escolhida não existe.");
            }

            Turma turma = turmas.get(escolha);

            CadastroResponsavel cadastroResponsavel = new CadastroResponsavel();
            Responsavel responsavel = cadastroResponsavel.CadastroResponsavel(escola, endereco);

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

            System.out.println("\n✅ Aluno cadastrado com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("\n❌ Erro: Entrada inválida. Digite os números corretamente.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\n❌ Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n❌ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}





package org.example.view;

import org.example.controller.ControleCadastroProfessor;
import org.example.model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pelo cadastro interativo de professores.
 * <p>
 * Permite ao usuário informar nome, data de nascimento, endereço, formação e telefone.
 * Também possibilita a vinculação do professor a uma turma existente, caso a turma não possua professor.
 * Professores podem ser cadastrados sem turma se nenhuma estiver disponível ou se a turma já tiver um professor.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class CadastroProfessor {

    /**
     * Executa o cadastro interativo de um professor na escola.
     * <p>
     * O método permite ao usuário:
     * <ul>
     *     <li>Informar os dados do professor (nome, data de nascimento, endereço, formação e telefone)</li>
     *     <li>Selecionar uma turma para vinculação, caso exista e não possua professor</li>
     *     <li>Cadastrar o professor sem turma se não houver turmas disponíveis ou se a turma escolhida já estiver ocupada</li>
     * </ul>
     *
     * @param escola Escola na qual o professor será cadastrado
     */
    public void CadastroProfessor(Escola escola) {
        ControleCadastroProfessor controleCadastroProfessor = new ControleCadastroProfessor();
        Scanner sc = new Scanner(System.in);
        List<Turma> turmas = escola.getTurmas();

        try {
            System.out.println("\n====================================");
            System.out.println("         Cadastrando Professor       ");
            System.out.println("====================================\n");

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Data de Nascimento (dd/mm/aaaa): ");
            String dataNascimento = sc.nextLine();

            CadastroEndereco cadastroEndereco = new CadastroEndereco();
            Endereco endereco = cadastroEndereco.CadastroEndereco();

            System.out.print("Formação: ");
            String formacao = sc.nextLine();

            System.out.print("Telefone: ");
            String telefone = sc.nextLine();

            Professor novoProfessor;

            if (turmas == null || turmas.isEmpty()) {
                // Nenhuma turma disponível, professor será cadastrado sem turma
                novoProfessor = controleCadastroProfessor.CadastroProfessor(escola, nome, dataNascimento, endereco,
                        formacao, null, telefone);
            } else {
                System.out.println("\nEscolha a Turma:");
                for (int i = 0; i < turmas.size(); i++) {
                    Turma t = turmas.get(i);
                    String status = (t.getProfessor() == null) ? " [Sem professor]" : " [Já possui professor]";
                    System.out.println("[" + i + "] " + t.getSerie() + "º " + t.getAnoLetivo() + status);
                }

                System.out.print("\nOpção: ");
                int escolha = sc.nextInt();
                sc.nextLine();

                if (escolha < 0 || escolha >= turmas.size()) {
                    // Turma inválida, professor cadastrado sem turma
                    System.out.println("\n⚠️ Escolha de turma inválida. Professor cadastrado sem turma.");
                    novoProfessor = controleCadastroProfessor.CadastroProfessor(escola, nome, dataNascimento, endereco,
                            formacao, null, telefone);
                } else {
                    Turma turma = turmas.get(escolha);

                    if (turma.getProfessor() != null) {
                        // Turma já possui professor, novo professor não é vinculado
                        System.out.println("\n⚠️ Esta turma já possui professor: " + turma.getProfessor().getNome());
                        System.out.println("Professor cadastrado sem turma.");
                        novoProfessor = controleCadastroProfessor.CadastroProfessor(escola, nome, dataNascimento, endereco,
                                formacao, null, telefone);
                    } else {
                        // Turma disponível, vincula professor
                        novoProfessor = controleCadastroProfessor.CadastroProfessor(escola, nome, dataNascimento, endereco,
                                formacao, turma, telefone);
                        turma.setProfessor(novoProfessor);
                        System.out.println("\n✅ Professor vinculado à turma com sucesso!");
                    }
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("\n❌ Erro: Entrada inválida. Digite apenas números ao escolher a turma.");
        } catch (Exception e) {
            System.out.println("\n❌ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}





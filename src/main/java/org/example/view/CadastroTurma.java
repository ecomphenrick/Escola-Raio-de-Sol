package org.example.view;

import org.example.controller.ControleCadastroTurma;
import org.example.model.Aluno;
import org.example.model.Escola;
import org.example.model.Professor;
import org.example.model.Turma;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pelo cadastro interativo de turmas na escola.
 * <p>
 * Permite ao usuário informar série, ano letivo e vincular um professor disponível.
 * Uma lista vazia de alunos é criada automaticamente.
 * A turma é registrada na escola através do {@link ControleCadastroTurma}.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class CadastroTurma {

    /**
     * Executa o cadastro interativo de uma nova turma.
     * <p>
     * O método solicita ao usuário:
     * <ul>
     *     <li>Série da turma (1 a 5)</li>
     *     <li>Ano letivo</li>
     *     <li>Escolha de professor disponível</li>
     * </ul>
     * Caso nenhum professor seja escolhido ou disponível, a turma será criada sem professor.
     * A turma é adicionada à escola e o professor, se selecionado, é vinculado à turma.
     * </p>
     *
     * @param escola Escola na qual a turma será cadastrada
     */
    public void CadastroTurma(Escola escola) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("\n====================================");
            System.out.println("            Cadastrando Turma        ");
            System.out.println("====================================\n");

            System.out.print("Digite a série [1 a 5]: ");
            int serie = sc.nextInt();
            sc.nextLine();

            if (serie < 1 || serie > 5) {
                System.out.println("\n⚠️ A escola não suporta essa série...");
                return;
            }

            System.out.print("Digite o ano letivo: ");
            int anoLetivo = sc.nextInt();
            sc.nextLine();

            Professor professorTurma = null;
            List<Professor> disponiveis = escola.getProfessoresSemTurma();

            if (!disponiveis.isEmpty()) {
                System.out.println("\nProfessores disponíveis:");
                for (int i = 0; i < disponiveis.size(); i++) {
                    System.out.println("[" + i + "] " + disponiveis.get(i).getNome());
                }

                System.out.print("\nEscolha um professor: ");
                int escolhaProf = sc.nextInt();
                sc.nextLine();

                if (escolhaProf < 0 || escolhaProf >= disponiveis.size()) {
                    System.out.println("\n⚠️ Escolha de professor inválida. Nenhum professor será atribuído.");
                } else {
                    professorTurma = disponiveis.get(escolhaProf);
                    escola.getProfessoresSemTurma().remove(professorTurma);
                }

            } else {
                System.out.println("\n⚠️ Nenhum professor disponível.");
            }

            List<Aluno> alunos = new ArrayList<>();
            ControleCadastroTurma cadastroTurma = new ControleCadastroTurma();
            Turma novaTurma = cadastroTurma.CadastroTurma(escola, serie, anoLetivo, professorTurma, alunos);

            if (professorTurma != null) {
                professorTurma.setTurma(novaTurma);
                novaTurma.setProfessor(professorTurma);
                System.out.println("\n✅ Professor vinculado à turma.");
            }

            System.out.println("\n✅ Turma cadastrada com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("\n❌ Erro: Entrada inválida. Digite apenas números.");
        } catch (Exception e) {
            System.out.println("\n❌ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}



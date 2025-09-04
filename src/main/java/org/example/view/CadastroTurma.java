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

public class CadastroTurma {

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


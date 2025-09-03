package org.example.view;

import org.example.controller.Cadastro;
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
        Cadastro cadastro = new Cadastro();

        try {
            System.out.println("Cadastrando Turma.");
            System.out.println("Digite a série: [1 ao 5]");

            int serie = sc.nextInt();
            sc.nextLine(); // limpar buffer

            if (serie < 1 || serie > 5) {
                System.out.println("A escola não suporta essa série...");
                return; // sai do método, pois a série é inválida
            }

            System.out.println("Digite o ano letivo: ");
            int anoLetivo = sc.nextInt();
            sc.nextLine(); // limpar buffer

            Professor professorTurma = null;

            List<Professor> disponiveis = escola.getProfessoresSemTurma();
            if (!disponiveis.isEmpty()) {
                System.out.println("Professores disponíveis:");
                for (int i = 0; i < disponiveis.size(); i++) {
                    System.out.println(i + " - " + disponiveis.get(i).getNome());
                }

                int escolhaProf = sc.nextInt();
                sc.nextLine(); // limpar buffer

                if (escolhaProf < 0 || escolhaProf >= disponiveis.size()) {
                    System.out.println("Escolha de professor inválida. Nenhum professor será atribuído.");
                } else {
                    professorTurma = disponiveis.get(escolhaProf);
                    escola.getProfessoresSemTurma().remove(professorTurma);
                }

            } else {
                System.out.println("Nenhum professor disponível.");
            }

            List<Aluno> alunos = new ArrayList<>();
            Turma novaTurma = cadastro.CadastroTurma(escola, serie, anoLetivo, professorTurma, alunos);

            if (professorTurma != null) {
                professorTurma.setTurma(novaTurma);
                novaTurma.setProfessor(professorTurma);
            }

            System.out.println("Turma cadastrada com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Digite apenas números.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}

package org.example.controller;

import org.example.model.Escola;
import org.example.model.Professor;
import org.example.model.Turma;

/**
 * Classe responsável por remover professores da escola e, se houver, das turmas a que estão vinculados.
 * <p>
 * Trata professores que estão vinculados a uma turma e aqueles sem turma, removendo-os da lista correspondente.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class RemoverProfessor {

    /**
     * Remove um professor específico da escola.
     * <p>
     * - Se o professor estiver vinculado a uma turma, remove a referência da turma.
     * - Remove o professor da lista de professores com turma ou da lista de professores sem turma.
     * - Caso o professor não seja encontrado em nenhuma lista, exibe mensagem informativa.
     * </p>
     *
     * @param escola Escola da qual o professor será removido
     * @param professor Professor a ser removido
     */
    public void RemoverProfessor(Escola escola, Professor professor) {
        if (professor == null || escola == null) {
            System.out.println("❌ Escola ou professor inválido.");
            return;
        }

        boolean removido = false;

        // Remove da lista de professores com turma
        if (escola.getProfessores() != null && escola.getProfessores().contains(professor)) {
            escola.getProfessores().remove(professor);
            removido = true;

            // Remove referência da turma, se existir
            Turma turma = professor.getTurma();
            if (turma != null) {
                turma.setProfessor(null);
            }

            System.out.println("✅ Professor removido da lista de professores com turma.");
        }

        // Remove da lista de professores sem turma
        else if (escola.getProfessoresSemTurma() != null && escola.getProfessoresSemTurma().contains(professor)) {
            escola.getProfessoresSemTurma().remove(professor);
            removido = true;
            System.out.println("✅ Professor removido da lista de professores sem turma.");
        }

        // Professor não encontrado em nenhuma lista
        if (!removido) {
            System.out.println("❌ Professor não encontrado.");
        }
    }
}


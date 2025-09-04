package org.example.controller;

import org.example.model.Escola;
import org.example.model.Professor;
import org.example.model.Turma;

public class RemoverProfessor {

    // Remove professor da escola e, se houver, da turma
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

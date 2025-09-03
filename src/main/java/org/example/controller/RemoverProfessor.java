package org.example.controller;

import org.example.model.Escola;
import org.example.model.Professor;

public class RemoverProfessor {
    // Remover professor
    public void RemoverProfessor(Escola escola, Professor professor) {
        if (escola.getProfessores().contains(professor)) {
            escola.getProfessores().remove(professor);
            System.out.println("✅ Professor removido da lista de professores com turma.");
        } else if (escola.getProfessoresSemTurma().contains(professor)) {
            escola.getProfessoresSemTurma().remove(professor);
            System.out.println("✅ Professor removido da lista de professores sem turma.");
        } else {
            System.out.println("❌ Professor não encontrado.");
        }
    }
}

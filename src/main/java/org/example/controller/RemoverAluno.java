package org.example.controller;

import org.example.model.Aluno;
import org.example.model.Escola;

public class RemoverAluno {
    public void RemoverAluno(Escola escola, Aluno aluno) {
        if (aluno.getTurma() != null) {
            if (aluno.getTurma().getAlunos() != null) {
                aluno.getTurma().getAlunos().remove(aluno);
            }
        }

        if (escola.getAlunos() != null) {
            escola.getAlunos().remove(aluno);
        }

        System.out.println("✅ Aluno removido com sucesso da escola e da turma.");
    }
}

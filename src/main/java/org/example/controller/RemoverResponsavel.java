package org.example.controller;

import org.example.model.Aluno;
import org.example.model.Escola;
import org.example.model.Responsavel;

public class RemoverResponsavel {
    public void RemoverResponsavel(Escola escola, Responsavel responsavel) {
        // Remove da lista de responsáveis
        if (escola.getResponsaveis() != null) {
            escola.getResponsaveis().remove(responsavel);
        }

        // Desvincula de todos os alunos
        if (escola.getAlunos() != null) {
            for (Aluno aluno : escola.getAlunos()) {
                if (aluno.getResponsavel() != null && aluno.getResponsavel().equals(responsavel)) {
                    aluno.setResponsavel(null);
                }
            }
        }
    }
}

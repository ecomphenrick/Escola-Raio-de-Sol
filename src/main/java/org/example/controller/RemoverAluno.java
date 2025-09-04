package org.example.controller;

import org.example.model.Aluno;
import org.example.model.Escola;
import org.example.model.Responsavel;

/**
 * Classe responsável por remover alunos da escola, da turma e seu responsável.
 * Cada responsável possui apenas um aluno.
 *
 * @author Henrick
 * @version 1.3
 */
public class RemoverAluno {

    /**
     * Remove um aluno específico da escola, da turma e seu responsável.
     *
     * @param escola Escola da qual o aluno será removido
     * @param aluno  Aluno a ser removido
     */
    public void RemoverAluno(Escola escola, Aluno aluno) {
        // Remove o aluno da turma, se existir
        if (aluno.getTurma() != null && aluno.getTurma().getAlunos() != null) {
            aluno.getTurma().getAlunos().remove(aluno);
        }

        // Remove o aluno da escola
        if (escola.getAlunos() != null) {
            escola.getAlunos().remove(aluno);
        }

        // Remove o responsável da escola
        Responsavel responsavel = aluno.getResponsavel();
        if (responsavel != null && escola.getResponsaveis() != null) {
            escola.getResponsaveis().remove(responsavel);
        }

        System.out.println("✅ Aluno e seu responsável removidos com sucesso.");
    }
}



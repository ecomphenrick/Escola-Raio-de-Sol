package org.example.controller;

import org.example.model.Aluno;
import org.example.model.Escola;
import org.example.model.Responsavel;

/**
 * Classe responsável por remover responsáveis da escola.
 * <p>
 * Remove o responsável da lista de responsáveis da escola e desvincula-o de todos os alunos
 * que estavam associados a ele.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class RemoverResponsavel {

    /**
     * Remove um responsável da escola e desvincula-o de todos os alunos que estavam associados a ele.
     *
     * @param escola Escola da qual o responsável será removido
     * @param responsavel Responsável a ser removido
     */
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


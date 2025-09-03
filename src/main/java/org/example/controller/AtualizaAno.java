package org.example.controller;

import org.example.model.Aluno;
import org.example.model.Escola;
import org.example.model.Turma;

import java.util.ArrayList;
import java.util.List;

public class AtualizaAno {

    public void atualizarAno(Escola escola) {
        try {
            List<Turma> turmas = escola.getTurmas();

            if (turmas == null || turmas.isEmpty()) {
                System.out.println("❌ Não há turmas cadastradas para atualizar.");
                return;
            }

            List<Turma> novasTurmas = new ArrayList<>();

            for (Turma turmaAntiga : turmas) {
                if (turmaAntiga == null) continue;

                int novaSerie = turmaAntiga.getSerie() + 1;
                int novoAnoLetivo = turmaAntiga.getAnoLetivo() + 1;

                if (novaSerie <= 5) {
                    // Atualiza cada aluno para a nova turma
                    List<Aluno> mesmosAlunos = turmaAntiga.getAlunos() != null ? turmaAntiga.getAlunos() : new ArrayList<>();
                    for (Aluno aluno : mesmosAlunos) {
                        aluno.setTurma(turmaAntiga); // aponta para a turma antiga atualizada
                    }

                    Turma novaTurma = new Turma(
                            novaSerie,
                            novoAnoLetivo,
                            turmaAntiga.getProfessor(),
                            mesmosAlunos
                    );

                    // Atualiza referência da turma para cada aluno
                    for (Aluno aluno : mesmosAlunos) {
                        aluno.setTurma(novaTurma);
                    }

                    novasTurmas.add(novaTurma);
                } else {
                    System.out.println("✅ Turma do 5º ano " + turmaAntiga.getAnoLetivo() + " se formou!");
                }
            }

            turmas.addAll(novasTurmas);
            System.out.println("✅ Atualização de turmas concluída com sucesso.");

        } catch (Exception e) {
            System.out.println("❌ Ocorreu um erro ao atualizar as turmas: " + e.getMessage());
        }
    }
}



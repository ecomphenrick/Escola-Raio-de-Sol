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
                System.out.println("\n❌ Não há turmas cadastradas para atualizar.");
                return;
            }

            List<Turma> novasTurmas = new ArrayList<>();

            for (Turma turmaAntiga : turmas) {
                if (turmaAntiga == null) continue;

                int novaSerie = turmaAntiga.getSerie() + 1;
                int novoAnoLetivo = turmaAntiga.getAnoLetivo() + 1;

                if (novaSerie <= 5) {
                    List<Aluno> mesmosAlunos = turmaAntiga.getAlunos() != null ? turmaAntiga.getAlunos() : new ArrayList<>();

                    Turma novaTurma = new Turma(
                            novaSerie,
                            novoAnoLetivo,
                            turmaAntiga.getProfessor(),
                            mesmosAlunos
                    );

                    for (Aluno aluno : mesmosAlunos) {
                        aluno.setTurma(novaTurma);
                    }

                    novasTurmas.add(novaTurma);
                    System.out.println("✅ Turma " + turmaAntiga.getSerie() + "º ano atualizada para " + novaSerie + "º ano.");
                } else {
                    System.out.println("🎓 Turma do 5º ano " + turmaAntiga.getAnoLetivo() + " se formou!");
                }
            }

            turmas.addAll(novasTurmas);
            System.out.println("\n✅ Atualização de turmas concluída com sucesso.");

        } catch (Exception e) {
            System.out.println("\n❌ Ocorreu um erro ao atualizar as turmas: " + e.getMessage());
        }
    }
}




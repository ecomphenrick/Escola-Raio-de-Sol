package org.example.controller;

import org.example.model.Aluno;
import org.example.model.Escola;
import org.example.model.Turma;

import java.util.Iterator;
import java.util.List;

public class AtualizaAno {

    public void atualizarAno(Escola escola) {
        try {
            List<Turma> turmas = escola.getTurmas();

            if (turmas == null || turmas.isEmpty()) {
                System.out.println("\n❌ Não há turmas cadastradas para atualizar.");
                return;
            }

            Iterator<Turma> iterator = turmas.iterator();

            while (iterator.hasNext()) {
                Turma turma = iterator.next();
                if (turma == null) continue;

                int novaSerie = turma.getSerie() + 1;
                int novoAnoLetivo = turma.getAnoLetivo() + 1;

                if (novaSerie <= 5) {
                    turma.setSerie(novaSerie);
                    turma.setAnoLetivo(novoAnoLetivo);
                    System.out.println("✅ Turma atualizada para " + novaSerie + "º ano - " + novoAnoLetivo);

                    // Atualiza cada aluno para continuar vinculado à mesma turma
                    if (turma.getAlunos() != null) {
                        for (Aluno aluno : turma.getAlunos()) {
                            aluno.setTurma(turma);
                        }
                    }

                } else {
                    System.out.println("🎓 Turma do 5º ano " + turma.getAnoLetivo() + " se formou e será removida.");
                    // Remove a turma da lista
                    iterator.remove();

                    // Desvincula os alunos da turma (se necessário)
                    if (turma.getAlunos() != null) {
                        for (Aluno aluno : turma.getAlunos()) {
                            aluno.setTurma(null);
                        }
                    }

                    // Desvincula professor da turma
                    if (turma.getProfessor() != null) {
                        turma.getProfessor().setTurma(null);
                    }
                }
            }

            System.out.println("\n✅ Atualização de turmas concluída com sucesso.");

        } catch (Exception e) {
            System.out.println("\n❌ Ocorreu um erro ao atualizar as turmas: " + e.getMessage());
        }
    }
}





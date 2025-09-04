package org.example.controller;

import org.example.model.Aluno;
import org.example.model.Escola;
import org.example.model.Turma;

import java.util.Iterator;
import java.util.List;

/**
 * Classe responsável por atualizar o ano letivo das turmas da escola.
 * <p>
 * O método {@link #atualizarAno(Escola)} incrementa a série e o ano letivo de cada turma.
 * Turmas que atingirem o 5º ano são consideradas formadas e removidas da escola.
 * Além disso, o vínculo dos alunos e professores é atualizado conforme a mudança.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class AtualizaAno {

    /**
     * Atualiza todas as turmas de uma escola para o próximo ano letivo.
     * <p>
     * - Incrementa série e ano letivo para turmas existentes.
     * - Remove turmas do 5º ano e desvincula alunos e professores.
     * - Mantém os alunos vinculados às turmas que continuam.
     * </p>
     *
     * @param escola Escola cujas turmas serão atualizadas
     */
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

                    if (turma.getAlunos() != null) {
                        for (Aluno aluno : turma.getAlunos()) {
                            aluno.setTurma(turma);
                        }
                    }

                } else {
                    System.out.println("🎓 Turma do 5º ano " + turma.getAnoLetivo() + " se formou e será removida.");
                    iterator.remove();

                    if (turma.getAlunos() != null) {
                        for (Aluno aluno : turma.getAlunos()) {
                            aluno.setTurma(null);
                        }
                    }

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






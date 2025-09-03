package org.example.controller;

import org.example.model.Aluno;
import org.example.model.Escola;
import org.example.model.Professor;
import org.example.model.Turma;

import java.util.ArrayList;
import java.util.List;

public class ControleCadastroTurma {
    // Método para criação da turma
    public Turma CadastroTurma(Escola escola, int serie, int anoLetivo, Professor professor, List<Aluno> alunos) {
        try {
            if (escola.getTurmas() == null) {
                escola.setTurmas(new ArrayList<>());
            }
            if (alunos == null) {
                alunos = new ArrayList<>();
            }

            Turma turmaCriada = new Turma(serie, anoLetivo, professor, alunos);
            escola.getTurmas().add(turmaCriada);

            System.out.println("✅ Turma do " + serie + "º ano, ano letivo " + anoLetivo + " cadastrada com sucesso.");

            return turmaCriada;
        } catch (Exception e) {
            System.out.println("❌ Erro ao cadastrar turma: " + e.getMessage());
            return null;
        }
    }
}

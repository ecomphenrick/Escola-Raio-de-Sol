package org.example.controller;

import org.example.model.*;

import java.util.ArrayList;
import java.util.List;

public class ControleCadastroProfessor {
    public Professor CadastroProfessor(Escola escola, String nome, String dataNascimento, Endereco endereco,
                                       String formacao, Turma turma, String telefone, List<Aluno> dependentes) {
        if (escola.getProfessores() == null) {
            escola.setProfessores(new ArrayList<>());
        }
        if (dependentes == null) {
            dependentes = new ArrayList<>();
        }

        Professor professor = new Professor(nome, dataNascimento, endereco, formacao, turma, telefone, dependentes);

        if (turma == null) {
            // sem turma, adiciona na lista de professores sem turma
            escola.adicionarProfessorSemTurma(professor);
            System.out.println("✅ Professor '" + nome + "' cadastrado sem turma.");
        } else {
            // com turma, adiciona na lista de professores com turma
            escola.getProfessores().add(professor);
            System.out.println("✅ Professor '" + nome + "' cadastrado com sucesso na turma "
                    + turma.getSerie() + "º ano.");
        }

        return professor;
    }
}

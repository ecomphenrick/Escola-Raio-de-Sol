package org.example.controller;

import org.example.model.*;

import java.util.ArrayList;
import java.util.List;

public class Cadastro {

    // Método para cadastro do Aluno
    public void CadastroAluno(Escola escola, String nome, String dataNascimento, Endereco endereco, String naturalidade, Responsavel responsavel, Turma turma) {
        try {
            if (escola.getAlunos() == null) {
                escola.setAlunos(new ArrayList<>());
            }
            if (turma.getAlunos() == null) {
                turma.setAlunos(new ArrayList<>());
            }

            Aluno aluno = new Aluno(nome, dataNascimento, endereco, naturalidade, responsavel, turma);

            turma.getAlunos().add(aluno);
            escola.getAlunos().add(aluno);

            System.out.println("✅ Aluno '" + nome + "' cadastrado com sucesso na turma " + turma.getSerie() + "º ano, " + turma.getAnoLetivo() + ".");
        } catch (Exception e) {
            System.out.println("❌ Erro ao cadastrar aluno: " + e.getMessage());
        }
    }

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

    // Método para cadastro do professor
    public Professor CadastroProfessor(Escola escola, String nome, String dataNascimento, Endereco endereco, String formacao, Turma turma, String telefone, List<Aluno> dependentes) {
        try {
            if (escola.getProfessores() == null) {
                escola.setProfessores(new ArrayList<>());
            }
            if (dependentes == null) {
                dependentes = new ArrayList<>();
            }

            Professor professor = new Professor(nome, dataNascimento, endereco, formacao, turma, telefone, dependentes);
            escola.getProfessores().add(professor);

            System.out.println("✅ Professor '" + nome + "' cadastrado com sucesso." + (turma != null ? " Vinculado à turma " + turma.getSerie() + "º ano." : " Sem turma vinculada."));

            return professor;
        } catch (Exception e) {
            System.out.println("❌ Erro ao cadastrar professor: " + e.getMessage());
            return null;
        }
    }
}


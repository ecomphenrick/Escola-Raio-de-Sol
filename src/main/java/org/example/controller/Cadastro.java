package org.example.controller;

import org.example.model.*;

import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    public void CadastroResponsavel (Escola escola, String nome, String dataNascimento, Endereco endereco, String telefone){
        Responsavel responsavel = new Responsavel(nome, dataNascimento, endereco, telefone, null);
        escola.getResponsaveis().add(responsavel);

    }

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

        // Cadastro do Professor
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

        // Remover professor
        public void RemoverProfessor(Escola escola, Professor professor) {
            if (escola.getProfessores().contains(professor)) {
                escola.getProfessores().remove(professor);
                System.out.println("✅ Professor removido da lista de professores com turma.");
            } else if (escola.getProfessoresSemTurma().contains(professor)) {
                escola.getProfessoresSemTurma().remove(professor);
                System.out.println("✅ Professor removido da lista de professores sem turma.");
            } else {
                System.out.println("❌ Professor não encontrado.");
            }
        }
        public void RemoverAluno(Escola escola, Aluno aluno) {
            if (aluno.getTurma() != null) {
                if (aluno.getTurma().getAlunos() != null) {
                    aluno.getTurma().getAlunos().remove(aluno);
                }
            }

            if (escola.getAlunos() != null) {
                escola.getAlunos().remove(aluno);
            }

            System.out.println("✅ Aluno removido com sucesso da escola e da turma.");
        }
}



package org.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma escola, contendo listas de turmas, professores, alunos e responsáveis.
 * <p>
 * A classe Escola permite gerenciar professores com e sem turma, além de manter
 * listas dos alunos, turmas e responsáveis cadastrados.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class Escola {

    private List<Turma> turmas;
    private List<Professor> professores;
    private List<Aluno> alunos;
    private List<Professor> professoresSemTurma = new ArrayList<>();
    private List<Responsavel> responsaveis;

    /**
     * Inicializa todas as listas como vazias.
     */
    public Escola() {
        this.turmas = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.professoresSemTurma = new ArrayList<>();
        this.responsaveis = new ArrayList<>();
    }

    public List<Responsavel> getResponsaveis() {
        return responsaveis;
    }

    public void setResponsaveis(List<Responsavel> responsaveis) {
        this.responsaveis = responsaveis;
    }

    public void adicionarProfessorSemTurma(Professor professor) {
        this.professoresSemTurma.add(professor);
    }

    public List<Professor> getProfessoresGeral() {
        List<Professor> geral = new ArrayList<>();
        geral.addAll(this.professores);
        geral.addAll(this.professoresSemTurma);
        return geral;
    }

    public List<Professor> getProfessoresSemTurma() {
        return professoresSemTurma;
    }

    public void setProfessoresSemTurma(List<Professor> professoresSemTurma) {
        this.professoresSemTurma = professoresSemTurma;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}

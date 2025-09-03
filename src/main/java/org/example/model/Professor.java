package org.example.model;

import java.util.List;

public class Professor extends Pessoa {
    private String formacao;
    private String telefone;
    private Turma turma;
    private List<Aluno> dependente;

    // Construtor da classe, (Ver como atualizar turma e como colocar os dependentes)
    public Professor(String nome, String dataNascimento, Endereco endereco, String formacao, Turma turma, String telefone, List<Aluno> dependente){
        super(nome, dataNascimento, endereco);
        this.formacao = formacao;
        this.turma = turma;
        this.telefone = telefone;
        this.dependente = dependente;
    }

    public List<Aluno> getDependente() {
        return dependente;
    }

    public void setDependente(List<Aluno> dependente) {
        this.dependente = dependente;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}

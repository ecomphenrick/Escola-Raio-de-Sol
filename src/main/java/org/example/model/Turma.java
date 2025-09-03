package org.example.model;

import java.util.List;

public class Turma {
    private int serie;
    private int anoLetivo;
    private Professor professor;
    private List<Aluno> alunos;
    //Construtor da classe
    public Turma (int serie, int anoLetivo, Professor professor, List<Aluno> alunos){
        this.serie = serie;
        this.anoLetivo = anoLetivo;
        this.professor = professor;
        this.alunos = alunos;
    }
    //Getters e Setters


    public int getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}

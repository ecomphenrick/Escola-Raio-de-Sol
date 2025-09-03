package org.example.controller;
import org.example.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Classe para cadastro
public class Cadastro {
    //Método para cadastro do Aluno.
    public void CadastroAluno(Escola escola, String nome, String dataNascimento, Endereco endereco, String naturalidade, Responsavel responsavel, Turma turma) {

        Aluno aluno = new Aluno(nome, dataNascimento, endereco, naturalidade, responsavel, turma); //Criação do Aluno

        turma.getAlunos().add(aluno); //Adicionando os alunos na classe turma.
        escola.getAlunos().add(aluno); //Adicionando os alunos na escola (realmente necesssário)

        System.out.println("Aluno Cadastrado.");

    }

    //Método para criação da turma.
    public Turma CadastroTurma(Escola escola, int serie, int anoLetivo, Professor professor, List<Aluno> alunos) {
        Turma turmaCriada = new Turma(serie, anoLetivo, professor, alunos); //Criação do novo aluno

        escola.getTurmas().add(turmaCriada); //Adicionando turma na escola
        System.out.println("Turma Cadastrada.");


        return turmaCriada;
    }

    //Método para cadastro do professor.
    public Professor CadastroProfessor(Escola escola, String nome, String dataNascimento, Endereco endereco, String formacao, Turma turma, String telefone, List<Aluno> dependente) {
        Professor professor = new Professor(nome, dataNascimento, endereco, formacao, turma, telefone, dependente); //Criando Professor.
        escola.getProfessores().add(professor); //Adicionando na Escola.
        System.out.println("Professor cadastrado.");


        return professor;
    }
}

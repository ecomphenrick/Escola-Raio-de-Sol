package org.example.controller;

import org.example.model.*;

import java.util.ArrayList;

public class ControleCadastroAluno {
    // Método para cadastro do Aluno
    public void ControleCadastroAluno(Escola escola, String nome, String dataNascimento, Endereco endereco, String naturalidade, Responsavel responsavel, Turma turma) {
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
}

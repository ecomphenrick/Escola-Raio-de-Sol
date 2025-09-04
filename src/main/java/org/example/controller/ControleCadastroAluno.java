package org.example.controller;

import org.example.model.*;

import java.util.ArrayList;

/**
 * Classe responsável pelo cadastro de alunos na escola e nas respectivas turmas.
 * <p>
 * O método {@link #ControleCadastroAluno(Escola, String, String, Endereco, String, Responsavel, Turma)}
 * cria um novo aluno, adiciona à lista de alunos da escola e à lista de alunos da turma.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class ControleCadastroAluno {

    /**
     * Cadastra um novo aluno na escola e na turma informada.
     * <p>
     * Garante que as listas de alunos da escola e da turma estejam inicializadas.
     * Vincula o aluno à turma e ao responsável, adicionando-o nas listas correspondentes.
     * </p>
     *
     * @param escola Escola onde o aluno será cadastrado
     * @param nome Nome do aluno
     * @param dataNascimento Data de nascimento do aluno
     * @param endereco Endereço do aluno
     * @param naturalidade Naturalidade do aluno
     * @param responsavel Responsável legal do aluno
     * @param turma Turma em que o aluno será inserido
     */
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


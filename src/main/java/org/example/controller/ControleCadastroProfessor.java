package org.example.controller;

import org.example.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo cadastro de professores na escola.
 * <p>
 * Permite cadastrar professores vinculados a uma turma ou sem turma.
 * Professores sem turma são adicionados a uma lista específica para futura alocação.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class ControleCadastroProfessor {

    /**
     * Cadastra um novo professor na escola.
     * <p>
     * - Se a turma informada for {@code null}, o professor será cadastrado como "sem turma" e
     *   adicionado à lista de professores sem turma da escola.
     * - Caso contrário, o professor é vinculado à turma e adicionado à lista de professores da escola.
     * </p>
     *
     * @param escola Escola onde o professor será cadastrado
     * @param nome Nome do professor
     * @param dataNascimento Data de nascimento do professor
     * @param endereco Endereço do professor
     * @param formacao Formação acadêmica do professor
     * @param turma Turma a ser vinculada ao professor (pode ser {@code null})
     * @param telefone Telefone de contato do professor
     * @return Objeto {@link Professor} criado
     */
    public Professor CadastroProfessor(Escola escola, String nome, String dataNascimento, Endereco endereco,
                                       String formacao, Turma turma, String telefone) {
        if (escola.getProfessores() == null) {
            escola.setProfessores(new ArrayList<>());
        }

        Professor professor = new Professor(nome, dataNascimento, endereco, formacao, turma, telefone);

        if (turma == null) {
            escola.adicionarProfessorSemTurma(professor);
            System.out.println("✅ Professor '" + nome + "' cadastrado sem turma.");
        } else {
            escola.getProfessores().add(professor);
            System.out.println("✅ Professor '" + nome + "' cadastrado com sucesso na turma "
                    + turma.getSerie() + "º ano.");
        }

        return professor;
    }
}


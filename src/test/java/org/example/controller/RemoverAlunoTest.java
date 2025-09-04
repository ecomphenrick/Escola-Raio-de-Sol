package org.example.controller;

import org.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RemoverAlunoTest {

    private RemoverAluno removerAluno;
    private Escola escola;
    private Turma turma;
    private Aluno aluno;
    private Endereco endereco;
    private Responsavel responsavel;

    @BeforeEach
    void setUp() {
        removerAluno = new RemoverAluno();

        endereco = new Endereco("Rua A", "123", "Centro", "Cidade X", "Estado Y");
        responsavel = new Responsavel("Maria", "01/01/1980", endereco, "999999999", null);

        escola = new Escola();
        escola.setAlunos(new ArrayList<>());

        turma = new Turma(5, 2025, null, new ArrayList<>());
        aluno = new Aluno("João", "10/10/2010", endereco, "Cidade X", responsavel, turma);

        // Adiciona aluno na escola e na turma
        escola.getAlunos().add(aluno);
        turma.getAlunos().add(aluno);
    }

    @Test
    void removerAluno() {
        // Executa a remoção
        removerAluno.RemoverAluno(escola, aluno);

        // Verifica se o aluno foi removido da escola
        assertFalse(escola.getAlunos().contains(aluno));
        assertEquals(0, escola.getAlunos().size());

        // Verifica se o aluno foi removido da turma
        assertFalse(turma.getAlunos().contains(aluno));
        assertEquals(0, turma.getAlunos().size());
    }
}

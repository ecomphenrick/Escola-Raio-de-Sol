package org.example.controller;

import org.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControleCadastroAlunoTest {

    private ControleCadastroAluno controle;
    private Escola escola;
    private Turma turma;
    private Endereco endereco;
    private Responsavel responsavel;
    private Professor professor;

    @BeforeEach
    void setUp() {
        controle = new ControleCadastroAluno();
        professor = new Professor("Jhon", "432", endereco, "fddss", turma, "fdvs");

        escola = new Escola();
        escola.setAlunos(new ArrayList<>());

        turma = new Turma(9, 2025, professor, null);
        turma.setAlunos(new ArrayList<>());
        turma.setSerie(5);
        turma.setAnoLetivo(2025);

        endereco = new Endereco("Rua A", "123", "Centro", "Cidade X", "Estado Y");

        responsavel = new Responsavel("Maria", "01/01/1980", endereco, "999999999", null);
    }

    @Test
    void controleCadastroAluno() {
        // Executa o cadastro
        controle.ControleCadastroAluno(escola, "João", "10/10/2010", endereco, "Cidade X", responsavel, turma);

        // Verifica se o aluno foi adicionado à lista da escola
        assertEquals(1, escola.getAlunos().size());
        assertEquals("João", escola.getAlunos().get(0).getNome());

        // Verifica se o aluno foi adicionado à lista da turma
        assertEquals(1, turma.getAlunos().size());
        assertEquals("João", turma.getAlunos().get(0).getNome());
    }
}

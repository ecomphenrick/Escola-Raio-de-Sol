package org.example.controller;

import org.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControleCadastroTurmaTest {

    private ControleCadastroTurma controle;
    private Escola escola;
    private Professor professor;
    private List<Aluno> alunos;

    @BeforeEach
    void setUp() {
        controle = new ControleCadastroTurma();

        escola = new Escola();
        escola.setTurmas(new ArrayList<>());

        professor = new Professor("Jhon", "432", null, "Matemática", null, "999999999");
        alunos = new ArrayList<>();
    }

    @Test
    void cadastroTurma() {
        // Executa o cadastro da turma
        Turma turma = controle.CadastroTurma(escola, 5, 2025, professor, alunos);

        // Verifica se a turma foi adicionada à escola
        assertEquals(1, escola.getTurmas().size());
        assertEquals(turma, escola.getTurmas().get(0));

        // Verifica os dados da turma
        assertEquals(5, turma.getSerie());
        assertEquals(2025, turma.getAnoLetivo());
        assertEquals(professor, turma.getProfessor());
        assertEquals(alunos, turma.getAlunos());
    }

    @Test
    void cadastroTurmaSemAlunos() {
        // Executa o cadastro da turma sem lista de alunos (null)
        Turma turma = controle.CadastroTurma(escola, 9, 2025, professor, null);

        // Verifica se a turma foi criada corretamente e lista de alunos está inicializada
        assertNotNull(turma.getAlunos());
        assertTrue(turma.getAlunos().isEmpty());
    }
}

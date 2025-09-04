package org.example.controller;

import org.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControleCadastroProfessorTest {

    private ControleCadastroProfessor controle;
    private Escola escola;
    private Turma turma;
    private Endereco endereco;

    @BeforeEach
    void setUp() {
        controle = new ControleCadastroProfessor();

        endereco = new Endereco("Rua B", "456", "Centro", "Cidade Y", "Estado Z");

        escola = new Escola();
        escola.setProfessores(new ArrayList<>());

        turma = new Turma(9, 2025, null, null);
        turma.setSerie(9);
        turma.setAnoLetivo(2025);
    }

    @Test
    void cadastroProfessorComTurma() {
        // Executa o cadastro com turma
        Professor professor = controle.CadastroProfessor(escola, "Jhon", "15/05/1980", endereco, "Matemática", turma, "999999999");

        // Verifica se o professor foi adicionado à lista da escola
        assertEquals(1, escola.getProfessores().size());
        assertEquals("Jhon", escola.getProfessores().get(0).getNome());

        // Verifica se o professor está associado à turma
        assertEquals(turma, professor.getTurma());
    }

    @Test
    void cadastroProfessorSemTurma() {
        // Executa o cadastro sem turma
        Professor professor = controle.CadastroProfessor(escola, "Ana", "20/02/1985", endereco, "Português", null, "888888888");

        // Verifica se o professor foi adicionado à lista de professores sem turma
        assertTrue(escola.getProfessoresSemTurma().contains(professor));
        assertEquals("Ana", professor.getNome());
    }
}


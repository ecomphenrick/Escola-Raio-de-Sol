package org.example.controller;

import org.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RemoverProfessorTest {

    private RemoverProfessor removerProfessor;
    private Escola escola;
    private Turma turma;
    private Professor professor;
    private Endereco endereco;

    @BeforeEach
    void setUp() {
        removerProfessor = new RemoverProfessor();

        endereco = new Endereco("Rua B", "456", "Centro", "Cidade Y", "Estado Z");

        escola = new Escola();
        escola.setProfessores(new ArrayList<>());

        // Inicializa turma com lista de professores
        turma = new Turma(9, 2025, null, null);
        turma.setProfessor(null);

        // Cria professor associado à turma
        professor = new Professor("Jhon", "432", endereco, "Matemática", turma, "999999999");

        // Adiciona professor na escola e na turma
        escola.getProfessores().add(professor);
        turma.setProfessor(professor);
    }

    @Test
    void removerProfessor() {
        // Executa a remoção
        removerProfessor.RemoverProfessor(escola, professor);

        // Verifica se o professor foi removido da escola
        assertFalse(escola.getProfessores().contains(professor));
        assertEquals(0, escola.getProfessores().size());

        // Verifica se o professor foi removido da turma (única referência)
        assertNull(turma.getProfessor());
    }

}

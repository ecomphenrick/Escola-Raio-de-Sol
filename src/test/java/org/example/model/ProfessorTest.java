package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {
    private Professor professor;
    private Endereco endereco;
    private Turma turma;
    private Aluno aluno;
    @BeforeEach
    void setUp() {
        endereco = new Endereco("A", "Feira VI", "44034-236", "Feira de Santana", "Bahia");
        turma = new Turma(8, 2024, null, null);
        professor = new Professor("Jhon", "21/02/1984", endereco, "História", turma, "75992658825", null);
        turma.setProfessor(professor); // vincula professor à turma
    }

    @Test
    void getDependente() {
        assertNull(professor.getDependente());
    }


    @Test
    void getFormacao() {
        assertEquals("História", professor.getFormacao());
    }

    @Test
    void setFormacao() {
        professor.setFormacao("Matemática");
        assertEquals("Matemática", professor.getFormacao());
    }

    @Test
    void getTelefone() {
        assertEquals("75992658825", professor.getTelefone());
    }

    @Test
    void setTelefone() {
        professor.setTelefone("75991112233");
        assertEquals("75991112233", professor.getTelefone());
    }

    @Test
    void getTurma() {
        assertEquals(turma, professor.getTurma());
    }

    @Test
    void setTurma() {
        Turma novaTurma = new Turma(9, 2025, null, null);
        professor.setTurma(novaTurma);
        assertEquals(novaTurma, professor.getTurma());
    }
}

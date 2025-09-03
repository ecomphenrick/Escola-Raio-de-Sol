package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private Aluno aluno;
    private Responsavel responsavel;
    private Turma turma;
    private Endereco endereco;
    private Professor professor;

    @BeforeEach
    void setUp() {
        responsavel = new Responsavel("Carlos", "20/10/93", endereco, "75992737232",null);
        endereco = new Endereco("A", "Feira VI", "44034-236", "Feira de Santana", "Bahia");
        professor = new Professor("Jhon", "21/02/1984", endereco, "História",turma, "75992658825", null);
        turma = new Turma(8, 2024, professor, null);
        aluno = new Aluno("João", "14/04/2002", endereco, "Brasileiro", responsavel, turma);
    }

    @Test
    void getNaturalidade() {
        assertEquals("Brasileiro", aluno.getNaturalidade());
    }

    @Test
    void setNaturalidade() {
        aluno.setNaturalidade("Italiano");
        assertEquals("Italiano", aluno.getNaturalidade());
    }

    @Test
    void getResponsavel() {
        assertEquals(responsavel, aluno.getResponsavel());
    }

    @Test
    void setResponsavel() {
        Responsavel novoResp = new Responsavel("Maria", "22/09/1987", endereco, "75992990245", null);
        aluno.setResponsavel(novoResp);
        assertEquals(novoResp, aluno.getResponsavel());
    }

    @Test
    void getTurma() {
        assertEquals(turma, aluno.getTurma());
    }

    @Test
    void setTurma() {
        Turma novaTurma = new Turma(9, 2025, professor, null);
        aluno.setTurma(novaTurma);
        assertEquals(novaTurma, aluno.getTurma());
    }
}

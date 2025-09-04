package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TurmaTest {
    private Professor professor;
    private Aluno aluno1;
    private Aluno aluno2;
    private Turma turma;
    private Endereco endereco;

    @BeforeEach
    void setUp() {
        endereco = new Endereco("A", "Feira VI", "44034-236", "Feira de Santana", "Bahia");

        professor = new Professor("Carlos", "10/05/1980", endereco, "Matemática", null, "75991112233");

        aluno1 = new Aluno("João", "15/09/2017", endereco, "Brasileiro", null, null);
        aluno2 = new Aluno("Pedro", "20/03/2016", endereco, "Brasileiro", null, null);

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno1);
        alunos.add(aluno2);

        turma = new Turma(9, 2024, professor, alunos);

        // Vincula a turma nos alunos
        aluno1.setTurma(turma);
        aluno2.setTurma(turma);
    }

    @Test
    void getAnoLetivo() {
        assertEquals(2024, turma.getAnoLetivo());
    }

    @Test
    void setAnoLetivo() {
        turma.setAnoLetivo(2025);
        assertEquals(2025, turma.getAnoLetivo());
    }

    @Test
    void getProfessor() {
        assertEquals(professor, turma.getProfessor());
    }

    @Test
    void setProfessor() {
        Professor novoProfessor = new Professor("Ana", "12/11/1985", endereco, "Português", null, "75992223344");
        turma.setProfessor(novoProfessor);
        assertEquals(novoProfessor, turma.getProfessor());
    }

    @Test
    void getSerie() {
        assertEquals(9, turma.getSerie());
    }

    @Test
    void setSerie() {
        turma.setSerie(8);
        assertEquals(8, turma.getSerie());
    }

    @Test
    void getAlunos() {
        assertTrue(turma.getAlunos().contains(aluno1));
        assertTrue(turma.getAlunos().contains(aluno2));
    }

    @Test
    void setAlunos() {
        Aluno novoAluno = new Aluno("Mariana", "10/01/2017", endereco, "Brasileira", null, null);
        List<Aluno> novaLista = new ArrayList<>();
        novaLista.add(novoAluno);

        turma.setAlunos(novaLista);

        assertEquals(1, turma.getAlunos().size());
        assertEquals(novoAluno, turma.getAlunos().get(0));
    }
}

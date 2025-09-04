package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EscolaTest {

    private Escola escola;
    private Professor professor1;
    private Professor professor2;
    private Aluno aluno1;
    private Aluno aluno2;
    private Turma turma;
    private Endereco endereco;
    private Responsavel responsavel;

    @BeforeEach
    void setUp() {
        List<Aluno> alunos = new ArrayList<>();

        escola = new Escola();
        endereco = new Endereco("A", "Feira VI", "44034-236", "Feira de Santana", "Bahia");

        professor1 = new Professor("Jhon", "21/02/1984", endereco, "História",turma, "75992658825");
        professor2 = new Professor("Ana", "21/02/1987", endereco, "Geografia", turma, "2637412367");
        responsavel = new Responsavel("Kaique", "23/04/2032", endereco, "888888382183", null);
        aluno1 = new Aluno("João", "15/09/2017", endereco, "Brasileiro", responsavel, turma);
        aluno2 = new Aluno("Pedro", "20/03/2016", endereco, "Brasileiro", responsavel, turma);
        alunos.add(aluno1);
        alunos.add(aluno2);
        turma = new Turma(8, 2024, professor1,alunos);

        escola.getProfessores().add(professor1);
        escola.getAlunos().add(aluno1);
        escola.getTurmas().add(turma);
    }

    @Test
    void adicionarProfessorSemTurma() {
        escola.adicionarProfessorSemTurma(professor2);
        assertTrue(escola.getProfessoresSemTurma().contains(professor2));
    }

    @Test
    void getProfessoresGeral() {
        escola.adicionarProfessorSemTurma(professor2);
        List<Professor> geral = escola.getProfessoresGeral();
        assertTrue(geral.contains(professor1));
        assertTrue(geral.contains(professor2));
    }

    @Test
    void getProfessoresSemTurma() {
        escola.adicionarProfessorSemTurma(professor2);
        assertEquals(1, escola.getProfessoresSemTurma().size());
        assertEquals(professor2, escola.getProfessoresSemTurma().get(0));
    }

    @Test
    void setProfessoresSemTurma() {
        List<Professor> lista = new ArrayList<>();
        lista.add(professor2);

        escola.setProfessoresSemTurma(lista);

        assertEquals(1, escola.getProfessoresSemTurma().size());
        assertEquals(professor2, escola.getProfessoresSemTurma().get(0));
    }

    @Test
    void getAlunos() {
        assertTrue(escola.getAlunos().contains(aluno1));
    }

    @Test
    void setAlunos() {
        List<Aluno> novaLista = new ArrayList<>();
        novaLista.add(aluno2);

        escola.setAlunos(novaLista);

        assertEquals(1, escola.getAlunos().size());
        assertEquals(aluno2, escola.getAlunos().get(0));
    }

    @Test
    void getProfessores() {
        assertTrue(escola.getProfessores().contains(professor1));
    }

    @Test
    void setProfessores() {
        List<Professor> novaLista = new ArrayList<>();
        novaLista.add(professor2);

        escola.setProfessores(novaLista);

        assertEquals(1, escola.getProfessores().size());
        assertEquals(professor2, escola.getProfessores().get(0));
    }

    @Test
    void getTurmas() {
        assertTrue(escola.getTurmas().contains(turma));
    }

    @Test
    void setTurmas() {
        List<Turma> novaLista = new ArrayList<>();
        Turma turmaNova = new Turma(9, 2025, professor2, null);
        novaLista.add(turmaNova);

        escola.setTurmas(novaLista);

        assertEquals(1, escola.getTurmas().size());
        assertEquals(turmaNova, escola.getTurmas().get(0));
    }
}

package org.example.controller;

import org.example.model.Aluno;
import org.example.model.Escola;
import org.example.model.Turma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AtualizaAnoTest {

    private Escola escola;
    private AtualizaAno atualizaAno;

    @BeforeEach
    void setUp() {
        escola = new Escola();
        escola.setTurmas(new ArrayList<>());
        atualizaAno = new AtualizaAno();
    }

    @Test
    void deveCriarNovaTurmaParaAlunos() {
        Turma turmaAntiga = new Turma(1, 2024, null, new ArrayList<>());
        Aluno aluno = new Aluno("João", "01/01/2010", null, "Brasileiro", null, turmaAntiga);
        turmaAntiga.getAlunos().add(aluno);
        escola.getTurmas().add(turmaAntiga);

        atualizaAno.atualizarAno(escola);

        // Agora deve ter 2 turmas: antiga + nova
        assertEquals(2, escola.getTurmas().size());

        Turma novaTurma = escola.getTurmas().get(1);
        assertEquals(2, novaTurma.getSerie());
        assertEquals(2025, novaTurma.getAnoLetivo());

        // Aluno deve ter sido atualizado para a nova turma
        assertEquals(novaTurma, aluno.getTurma());
    }

    @Test
    void naoDeveCriarTurmaSeNaoExistirNenhuma() {
        atualizaAno.atualizarAno(escola);
        assertTrue(escola.getTurmas().isEmpty(), "Não deveria criar turmas quando não há nenhuma cadastrada");
    }

    @Test
    void naoDeveCriarTurmaParaSerieMaiorQue5() {
        Turma turma5Ano = new Turma(5, 2024, null, new ArrayList<>());
        escola.getTurmas().add(turma5Ano);

        atualizaAno.atualizarAno(escola);

        // Continua só 1 turma, pois o 5º ano se forma
        assertEquals(1, escola.getTurmas().size());
    }

    @Test
    void deveIgnorarTurmasNulas() {
        escola.getTurmas().add(null); // adicionando turma nula
        atualizaAno.atualizarAno(escola);

        // Lista continua só com null, sem crash
        assertEquals(1, escola.getTurmas().size());
    }
}

package org.example.controller;

import org.example.model.*;
import org.example.view.AtualizarAluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AtualizarAlunoTest {

    private Escola escola;
    private Aluno aluno;
    private AtualizarAluno atualizarAluno;

    @BeforeEach
    void setUp() {
        Endereco endereco = new Endereco("Rua A", "Centro", "12345-678", "Cidade X", "Estado Y");
        aluno = new Aluno("João", "01/01/2010", endereco, "Brasileiro", null, null);
        escola = new Escola();
        escola.setTurmas(new ArrayList<>());
        atualizarAluno = new AtualizarAluno();
    }

    private String executarComEntrada(String entrada) {
        // Simula entrada no Scanner
        ByteArrayInputStream in = new ByteArrayInputStream(entrada.getBytes());
        System.setIn(in);

        // Captura saída do console
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        atualizarAluno.AtualizarAluno(escola, aluno);

        return out.toString();
    }

    @Test
    void deveAtualizarNome() {
        String saida = executarComEntrada("0\nMaria\n");

        assertEquals("Maria", aluno.getNome());
        assertTrue(saida.contains("✅ Nome atualizado com sucesso."));
    }

    @Test
    void deveAtualizarDataNascimento() {
        String saida = executarComEntrada("1\n02/02/2011\n");

        assertEquals("02/02/2011", aluno.getDataNascimento());
        assertTrue(saida.contains("✅ Data de nascimento atualizada com sucesso."));
    }

    @Test
    void deveAtualizarEndereco() {
        String entrada = "2\nRua Nova\nBairro Novo\n98765-432\nCidade Nova\nEstado Novo\n";
        String saida = executarComEntrada(entrada);

        assertEquals("Rua Nova", aluno.getEndereco().rua);
        assertTrue(saida.contains("✅ Endereço atualizado com sucesso."));
    }

    @Test
    void deveAtualizarNaturalidade() {
        String saida = executarComEntrada("3\nItabuna\n");

        assertEquals("Itabuna", aluno.getNaturalidade());
        assertTrue(saida.contains("✅ Naturalidade atualizada com sucesso."));
    }

    @Test
    void deveAtualizarResponsavel() {
        String entrada = "4\nCarlos\n10/10/1980\n759999999\n";
        String saida = executarComEntrada(entrada);

        assertNotNull(aluno.getResponsavel());
        assertEquals("Carlos", aluno.getResponsavel().getNome());
        assertTrue(saida.contains("✅ Responsável atualizado com sucesso."));
    }

    @Test
    void deveAtualizarTurma() {
        // Cria turmas
        Turma turma1 = new Turma(1, 2024, null, new ArrayList<>());
        Turma turma2 = new Turma(2, 2025, null, new ArrayList<>());
        escola.getTurmas().add(turma1);
        escola.getTurmas().add(turma2);

        // Entrada: opção 5 + escolha turma 1
        String entrada = "5\n1\n";
        String saida = executarComEntrada(entrada);

        assertEquals(turma2, aluno.getTurma());
        assertTrue(turma2.getAlunos().contains(aluno));
        assertTrue(saida.contains("✅ Turma atualizada com sucesso."));
    }

    @Test
    void deveSairSemErroSeOpcaoInvalida() {
        String saida = executarComEntrada("9\n");
        assertTrue(saida.contains("Saindo da edição..."));
    }

    @Test
    void deveTratarEntradaInvalida() {
        String saida = executarComEntrada("abc\n"); // força InputMismatch
        assertTrue(saida.contains("❌ Entrada inválida"));
    }
}

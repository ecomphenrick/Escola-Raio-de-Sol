package org.example.controller;

import org.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RemoverResponsavelTest {

    private RemoverResponsavel removerResponsavel;
    private Escola escola;
    private Endereco endereco;
    private Responsavel responsavel;
    private Aluno aluno1;
    private Aluno aluno2;

    @BeforeEach
    void setUp() {
        removerResponsavel = new RemoverResponsavel();

        endereco = new Endereco("Rua D", "101", "Centro", "Cidade W", "Estado V");

        escola = new Escola();
        escola.setResponsaveis(new ArrayList<>());
        escola.setAlunos(new ArrayList<>());

        responsavel = new Responsavel("Carlos", "01/01/1980", endereco, "999999999", null);
        escola.getResponsaveis().add(responsavel);

        // Cria alunos vinculados ao responsável
        aluno1 = new Aluno("João", "10/10/2010", endereco, "Cidade X", responsavel, null);
        aluno2 = new Aluno("Maria", "20/05/2011", endereco, "Cidade Y", responsavel, null);
        escola.getAlunos().add(aluno1);
        escola.getAlunos().add(aluno2);
    }

    @Test
    void removerResponsavel() {
        // Executa a remoção
        removerResponsavel.RemoverResponsavel(escola, responsavel);

        // Verifica se o responsável foi removido da lista da escola
        assertFalse(escola.getResponsaveis().contains(responsavel));
        assertEquals(0, escola.getResponsaveis().size());

        // Verifica se o responsável foi desvinculado de todos os alunos
        assertNull(aluno1.getResponsavel());
        assertNull(aluno2.getResponsavel());
    }
}

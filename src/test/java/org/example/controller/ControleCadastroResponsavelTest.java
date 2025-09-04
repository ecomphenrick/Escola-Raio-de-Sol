package org.example.controller;

import org.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControleCadastroResponsavelTest {

    private ControleCadastroResponsavel controle;
    private Escola escola;
    private Endereco endereco;

    @BeforeEach
    void setUp() {
        controle = new ControleCadastroResponsavel();

        endereco = new Endereco("Rua C", "789", "Centro", "Cidade Z", "Estado W");

        escola = new Escola();
        escola.setResponsaveis(new ArrayList<>());
    }

    @Test
    void cadastroResponsavel() {
        // Executa o cadastro (método void)
        controle.ControleCadastroResponsavel(escola, "Carlos", "01/01/1980", endereco, "999999999");

        // Verifica se o responsável foi adicionado à escola
        assertEquals(1, escola.getResponsaveis().size());
        assertEquals("Carlos", escola.getResponsaveis().get(0).getNome());
        assertEquals("01/01/1980", escola.getResponsaveis().get(0).getDataNascimento());
        assertEquals("999999999", escola.getResponsaveis().get(0).getTelefone());
        assertEquals(endereco, escola.getResponsaveis().get(0).getEndereco());
    }
}

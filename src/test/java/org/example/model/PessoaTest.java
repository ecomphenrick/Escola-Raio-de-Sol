package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {
    private Endereco endereco;
    private Pessoa pessoa;

    @BeforeEach
    void setUp() {
        endereco = new Endereco("A", "Feira VI", "44034-236", "Feira de Santana", "Bahia");
        pessoa = new Pessoa("Jhon", "21/03/1984", endereco);
    }

    @Test
    void getDataNascimento() {
        assertEquals("21/03/1984", pessoa.getDataNascimento());
    }

    @Test
    void setDataNascimento() {
        pessoa.setDataNascimento("15/09/2000");
        assertEquals("15/09/2000", pessoa.getDataNascimento());
    }

    @Test
    void getEndereco() {
        assertEquals(endereco, pessoa.getEndereco());
    }

    @Test
    void setEndereco() {
        Endereco novoEndereco = new Endereco("B", "Centro", "44000-000", "Salvador", "Bahia");
        pessoa.setEndereco(novoEndereco);
        assertEquals(novoEndereco, pessoa.getEndereco());
    }

    @Test
    void getNome() {
        assertEquals("Jhon", pessoa.getNome());
    }

    @Test
    void setNome() {
        pessoa.setNome("Carlos");
        assertEquals("Carlos", pessoa.getNome());
    }
}

package org.example.model;

/**
 * Representa uma pessoa genérica com informações básicas como nome, data de nascimento e endereço.
 * <p>
 * A classe Pessoa serve como superclasse para outras classes, como {@link Aluno} e {@link Professor}.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class Pessoa {

    protected String nome;
    protected String dataNascimento;
    protected Endereco endereco;

    public Pessoa(String nome, String dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}





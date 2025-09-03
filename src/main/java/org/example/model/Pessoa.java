package org.example.model;

public class Pessoa {
    protected String nome;
    protected String dataNascimento;
    protected Endereco endereco;

    //Atributos protect para as subclasses acessarem
    //Contrutor da classe Pessoa.
    public Pessoa (String nome, String dataNascimento, Endereco endereco){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    //Getters e Setters
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}




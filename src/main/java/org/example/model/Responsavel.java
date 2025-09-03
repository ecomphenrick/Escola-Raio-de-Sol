package org.example.model;

import java.util.List;

public class Responsavel extends Pessoa {

    private String telefone;
    private List<Aluno> dependentes;

    //Construtor da classe responsável. (Ver se dependentes está funcioanndo corretamente)
    public Responsavel (String nome, String dataNascimento, Endereco endereco, String telefone, List<Aluno> dependentes){
        super(nome, dataNascimento, endereco);
        this.telefone = telefone;
        this.dependentes = dependentes;

    }
    //Getters e Setters
    public List<Aluno> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Aluno> dependentes) {
        this.dependentes = dependentes;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}


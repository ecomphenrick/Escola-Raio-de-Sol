package org.example.model;

import java.util.List;

/**
 * Representa um responsável legal por um ou mais alunos.
 * <p>
 * A classe Responsavel estende {@link Pessoa} e adiciona informações específicas
 * como telefone de contato e lista de dependentes (alunos sob sua responsabilidade).
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class Responsavel extends Pessoa {

    private String telefone;
    private List<Aluno> dependentes;

    //Construtor da classe responsável.
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



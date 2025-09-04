package org.example.model;

/**
 * Representa um professor da escola.
 * <p>
 * A classe Professor estende {@link Pessoa} e adiciona informações específicas
 * como formação, telefone e turma atribuída.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class Professor extends Pessoa {

    private String formacao;
    private String telefone;
    private Turma turma;

    public Professor(String nome, String dataNascimento, Endereco endereco, String formacao, Turma turma, String telefone) {
        super(nome, dataNascimento, endereco);
        this.formacao = formacao;
        this.turma = turma;
        this.telefone = telefone;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}

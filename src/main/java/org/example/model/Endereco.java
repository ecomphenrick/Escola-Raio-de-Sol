package org.example.model;

/**
 * Representa um endereço de um indivíduo ou instituição.
 * <p>
 * A classe Endereco contém informações detalhadas como rua, bairro, CEP, cidade e estado.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class Endereco {
    public String rua;
    public String bairro;
    public String cep;
    public String cidade;
    public String estado;

    public Endereco(String rua, String bairro, String cep, String cidade, String estado) {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }
}


package org.example.model;

// Classe endereço organizada, (talvez precise fazer o construtor.)
public class Endereco {
    public String rua;
    public String bairro;
    public String cep;
    public String cidade;
    public String estado;

    public Endereco (String rua, String bairro, String cep, String cidade, String estado){
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

}

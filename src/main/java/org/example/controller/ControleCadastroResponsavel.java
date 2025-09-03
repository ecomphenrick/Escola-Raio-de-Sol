package org.example.controller;

import org.example.model.Endereco;
import org.example.model.Escola;
import org.example.model.Responsavel;

public class ControleCadastroResponsavel {
    public void ControleCadastroResponsavel (Escola escola, String nome, String dataNascimento, Endereco endereco, String telefone){
        Responsavel responsavel = new Responsavel(nome, dataNascimento, endereco, telefone, null);
        escola.getResponsaveis().add(responsavel);
    }
}

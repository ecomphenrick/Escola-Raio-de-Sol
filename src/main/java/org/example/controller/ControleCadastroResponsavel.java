package org.example.controller;

import org.example.model.Endereco;
import org.example.model.Escola;
import org.example.model.Responsavel;

import java.util.List;

/**
 * Classe responsável pelo cadastro de responsáveis na escola.
 * <p>
 * Permite criar um novo responsável e adicioná-lo à lista de responsáveis da escola.
 * Inicialmente, os responsáveis não possuem dependentes cadastrados.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class ControleCadastroResponsavel {

    /**
     * Cadastra um novo responsável na escola.
     * <p>
     * Cria um objeto {@link Responsavel} com os dados fornecidos e adiciona à lista de
     * responsáveis da escola. Inicialmente, a lista de dependentes do responsável é nula.
     * </p>
     *
     * @param escola Escola onde o responsável será cadastrado
     * @param nome Nome do responsável
     * @param dataNascimento Data de nascimento do responsável
     * @param endereco Endereço do responsável
     * @param telefone Telefone de contato do responsável
     */
    public void ControleCadastroResponsavel(Escola escola, String nome, String dataNascimento, Endereco endereco, String telefone) {
        Responsavel responsavel = new Responsavel(nome, dataNascimento, endereco, telefone, null);

        // Garante que a lista de responsáveis não é nula
        if (escola.getResponsaveis() == null) {
            escola.setResponsaveis(new java.util.ArrayList<>());
        }

        escola.getResponsaveis().add(responsavel);
    }
}


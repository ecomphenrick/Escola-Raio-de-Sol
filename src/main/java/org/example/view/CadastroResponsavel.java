package org.example.view;

import org.example.controller.ControleCadastroResponsavel;
import org.example.model.Aluno;
import org.example.model.Endereco;
import org.example.model.Escola;
import org.example.model.Responsavel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pelo cadastro interativo de responsáveis na escola.
 * <p>
 * Permite ao usuário informar nome, data de nascimento, telefone e vincular um endereço existente.
 * Cria automaticamente uma lista vazia de dependentes para o responsável.
 * O responsável é adicionado à lista de responsáveis da escola através do {@link ControleCadastroResponsavel}.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class CadastroResponsavel {
    Scanner sc = new Scanner(System.in);

    /**
     * Executa o cadastro interativo de um responsável.
     * <p>
     * O método solicita ao usuário:
     * <ul>
     *     <li>Nome do responsável</li>
     *     <li>Data de nascimento</li>
     *     <li>Telefone</li>
     * </ul>
     * Além disso, vincula o responsável ao endereço fornecido e registra o responsável na escola.
     * Uma lista vazia de dependentes é criada automaticamente.
     * </p>
     *
     * @param escola Escola na qual o responsável será cadastrado
     * @param endereco Endereço que será vinculado ao responsável
     * @return Objeto {@link Responsavel} criado
     */
    public Responsavel CadastroResponsavel(Escola escola, Endereco endereco) {
        System.out.println("\n====================================");
        System.out.println("        Cadastrando Responsável      ");
        System.out.println("====================================\n");

        System.out.print("Nome do responsável: ");
        String nomeResp = sc.nextLine();

        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
        String dataResp = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        List<Aluno> dependentes = new ArrayList<>();
        Responsavel responsavel = new Responsavel(nomeResp, dataResp, endereco, telefone, dependentes);

        ControleCadastroResponsavel controleCadastroResponsavel = new ControleCadastroResponsavel();
        controleCadastroResponsavel.ControleCadastroResponsavel(escola, nomeResp, dataResp, endereco, telefone);

        System.out.println("\n✅ Responsável cadastrado com sucesso!\n");

        return responsavel;
    }
}



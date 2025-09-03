package org.example.view;

import org.example.controller.AtualizarAluno;
import org.example.controller.Cadastro;
import org.example.controller.RemoverAluno;
import org.example.model.Aluno;
import org.example.model.Escola;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuBuscaAluno {
    Scanner sc = new Scanner(System.in);
    Cadastro cadastro = new Cadastro();

    public void ExibirMenuAluno(Escola escola) {
        try {
            System.out.println("0 - Ler");
            System.out.println("1 - Atualizar");
            System.out.println("2 - Deletar");
            System.out.println("3 - Sair");

            int acao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            System.out.println("Digite o nome do aluno: ");
            String nome = sc.nextLine().trim();

            Aluno buscado = buscarAlunoPorNome(escola, nome);

            if (buscado == null) {
                System.out.println("❌ Não há aluno com esse nome aqui.");
            } else {
                switch (acao) {
                    case 0:
                        System.out.println("Nome: " + buscado.getNome());
                        System.out.println("Data de Nascimento: " + buscado.getDataNascimento());
                        System.out.println("Endereço: " + buscado.getEndereco().bairro + " - " + buscado.getEndereco().estado );
                        System.out.println("Naturalidade: " + buscado.getNaturalidade());
                        if(buscado.getResponsavel()!=null){
                            System.out.println("Responsável: " + buscado.getResponsavel().getNome());
                        }else{
                            System.out.println("Sem responsável cadastrado.");
                        }
                        if (buscado.getTurma() != null) {
                            System.out.println("Turma: " + buscado.getTurma().getSerie() + " - " + buscado.getTurma().getAnoLetivo());
                        } else {
                            System.out.println("Turma: Sem turma atribuída.");
                        }
                        break;
                    case 1:
                        AtualizarAluno atualizarAluno = new AtualizarAluno();
                        atualizarAluno.AtualizarAluno(escola, buscado);
                        break;
                    case 2:
                        RemoverAluno removerAluno =new RemoverAluno();
                        removerAluno.RemoverAluno(escola, buscado);
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("❌ Opção inválida.");
                        break;
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("❌ Entrada inválida. Digite apenas números para a opção.");
            sc.nextLine(); // limpar buffer
        } catch (Exception e) {
            System.out.println("❌ Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    private Aluno buscarAlunoPorNome(Escola escola, String nome) {
        if (escola.getAlunos() != null) {
            for (Aluno a : escola.getAlunos()) {
                if (a.getNome().equalsIgnoreCase(nome)) return a;
            }
        }
        return null;
    }
}



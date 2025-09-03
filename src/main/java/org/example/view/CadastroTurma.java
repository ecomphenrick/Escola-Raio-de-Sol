package org.example.view;


import org.example.controller.Cadastro;
import org.example.model.Aluno;
import org.example.model.Escola;
import org.example.model.Professor;
import org.example.model.Turma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroTurma {
    public void CadastroTurma(Escola escola){
        Scanner sc = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();
        System.out.println("Cadastrando Turma.");
        System.out.println("Digite a série: ");
        int serie = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o ano letivo: ");
        int anoLetivo = sc.nextInt();
        sc.nextLine();

        Professor professorTurma = null;

        if(!escola.getProfessoresSemTurma().isEmpty()){
            System.out.println("Professores disponíveis:");
            List<Professor> disponiveis = escola.getProfessoresSemTurma();
            for(int i = 0; i < disponiveis.size(); i++){
                System.out.println(i + " - " + disponiveis.get(i).getNome());
            }
            int escolhaProf = sc.nextInt();
            sc.nextLine();
            professorTurma = disponiveis.get(escolhaProf);
            escola.getProfessoresSemTurma().remove(professorTurma);
        } else {
            System.out.println("Nenhum professor disponível");
        }

        List<Aluno> alunos = new ArrayList<>();
        Turma novaTurma = cadastro.CadastroTurma(escola, serie, anoLetivo, professorTurma, alunos);

        if(professorTurma != null){
            professorTurma.setTurma(novaTurma);
            novaTurma.setProfessor(professorTurma);
        }

    }
}
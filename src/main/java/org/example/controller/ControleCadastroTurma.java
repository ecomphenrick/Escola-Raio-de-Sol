package org.example.controller;

import org.example.model.Aluno;
import org.example.model.Escola;
import org.example.model.Professor;
import org.example.model.Turma;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo cadastro de turmas na escola.
 * <p>
 * Permite criar novas turmas, associar professores e alunos, e adicioná-las à lista de turmas da escola.
 * </p>
 *
 * @author Henrick
 * @version 1.0
 */
public class ControleCadastroTurma {

    /**
     * Cadastra uma nova turma na escola.
     * <p>
     * - Garante que a lista de turmas da escola esteja inicializada.
     * - Garante que a lista de alunos da turma seja inicializada caso não seja fornecida.
     * - Cria uma nova turma, adiciona à lista da escola e retorna o objeto criado.
     * </p>
     *
     * @param escola Escola onde a turma será cadastrada
     * @param serie Série da turma (1º ao 5º ano)
     * @param anoLetivo Ano letivo da turma
     * @param professor Professor responsável pela turma
     * @param alunos Lista de alunos da turma (pode ser {@code null})
     * @return Objeto {@link Turma} criado, ou {@code null} em caso de erro
     */
    public Turma CadastroTurma(Escola escola, int serie, int anoLetivo, Professor professor, List<Aluno> alunos) {
        try {
            if (escola.getTurmas() == null) {
                escola.setTurmas(new ArrayList<>());
            }
            if (alunos == null) {
                alunos = new ArrayList<>();
            }

            Turma turmaCriada = new Turma(serie, anoLetivo, professor, alunos);
            escola.getTurmas().add(turmaCriada);

            System.out.println("✅ Turma do " + serie + "º ano, ano letivo " + anoLetivo + " cadastrada com sucesso.");

            return turmaCriada;
        } catch (Exception e) {
            System.out.println("❌ Erro ao cadastrar turma: " + e.getMessage());
            return null;
        }
    }
}


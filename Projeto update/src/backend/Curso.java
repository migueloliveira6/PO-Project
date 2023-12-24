package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso implements Serializable{

    private String designacao;
    private Professor diretorCurso;
    private List<UnidadeCurricular> unidadesCurriculares;
    private List<Aluno> alunos;
    private List<Professor> professores;

    public Curso(){
        
    }
    
    public Curso(String designacao, Professor diretorCurso, List<UnidadeCurricular> unidadesCurriculares, List<Aluno> alunos) {
        this.designacao = designacao;
        this.diretorCurso = diretorCurso;
        this.unidadesCurriculares = unidadesCurriculares;
        this.alunos = alunos;
    }

    public String getDesignacao() {
        return designacao;
    }

    public Professor getDiretorCurso() {
        return diretorCurso;
    }

    public List<UnidadeCurricular> getUnidadesCurriculares() {
        return unidadesCurriculares;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setDiretorCurso(Professor diretorCurso) {
        this.diretorCurso = diretorCurso;
    }

    public void setUnidadesCurriculares(List<UnidadeCurricular> unidadesCurriculares) {
        this.unidadesCurriculares = unidadesCurriculares;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
    
    public void adicionarAlunoaoCurso(Aluno aluno) {
        if (alunos == null) {
            alunos = new ArrayList<>();
        }
        alunos.add(aluno);
        System.out.println("Aluno adicionado ao curso com sucesso!");
    }
    
    public void removerAlunoDoCurso(Aluno aluno) {
        if (alunos != null) {
            alunos.remove(aluno);
            System.out.println("Aluno removido do Curso com sucesso!");
        } else {
            System.err.println("Não existe alunos.");
        }
    }
    
    public int getNumProfsCurso(){
        return professores.size();
    }
    
    public int getNumAlunosCurso(){
        return alunos.size();
    }

    @Override
    public String toString() {
        return "Curso{" + "designacao=" + designacao + ", diretorCurso=" + diretorCurso + ", unidadesCurriculares=" + 
                unidadesCurriculares + ", alunos=" + alunos + ", professores=" + professores + '}';
    }
}

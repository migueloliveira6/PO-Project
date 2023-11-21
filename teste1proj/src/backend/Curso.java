package backend;

import java.util.List;

public class Curso {

    private String designacao;
    private Professor diretorCurso;
    private List<UnidadeCurricular> unidadesCurriculares;
    private List<Aluno> alunos;

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
}

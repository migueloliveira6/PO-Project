package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
            System.err.println("Não existe alunos no curso.");
        }
    }
    
    public void adicionarProfaoCurso(Professor prof) {
        if (professores == null) {
            professores = new ArrayList<>();
        }
        professores.add(prof);
        System.out.println("Professor adicionado ao curso com sucesso!");
    }
    
    public void removerProfDoCurso(Professor prof) {
        if (professores != null) {
            professores.remove(prof);
            System.out.println("Professor removido do Curso com sucesso!");
        } else {
            System.err.println("Não existe professores no curso.");
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
        StringBuilder sb = new StringBuilder();
        sb.append("Curso{designacao=").append(designacao);

        // Adicione informações específicas sobre o diretor do curso
        if (diretorCurso != null) {
            sb.append(", diretorCurso=").append(diretorCurso.getNome());
        } else {
            sb.append(", diretorCurso=null");
        }

        // Verifique se unidadesCurriculares não é nulo antes de chamar size()
        if (unidadesCurriculares != null) {
            sb.append(", numUnidadesCurriculares=").append(unidadesCurriculares.size());
        } else {
            sb.append(", numUnidadesCurriculares=0");
        }

        // Verifique se alunos não é nulo antes de chamar size()
        if (alunos != null) {
            sb.append(", numAlunos=").append(alunos.size());
        } else {
            sb.append(", numAlunos=0");
        }

        // Verifique se professores não é nulo antes de chamar size()
        if (professores != null) {
            sb.append(", numProfessores=").append(professores.size());
        } else {
            sb.append(", numProfessores=0");
        }

        sb.append('}');
        return sb.toString();
    }
}

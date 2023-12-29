package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SumarioAula implements Serializable{
    private String titulo;
    private String tipo;
    private String sumario;
    private Professor professor;
    private UnidadeCurricular unidadeCurricular;
    private ArrayList<Aluno> alunosPresentes;

    public SumarioAula(){
        
    }
    
    public SumarioAula(String titulo, String tipo, String sumario, Professor professor, UnidadeCurricular unidadeCurricular) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.sumario = sumario;
        this.professor = professor;
        this.unidadeCurricular = unidadeCurricular;
        this.alunosPresentes = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getSumario() {
        return sumario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public UnidadeCurricular getUnidadeCurricular() {
        return unidadeCurricular;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setUnidadeCurricular(UnidadeCurricular unidadeCurricular) {
        this.unidadeCurricular = unidadeCurricular;
    }
    
    public void adicionarAlunoPresente(Aluno aluno) {
        this.alunosPresentes.add(aluno);
    }

    public void removerAlunoPresente(Aluno aluno) {
        this.alunosPresentes.remove(aluno);
    }

    public List<Aluno> getAlunosPresentes() {
        return this.alunosPresentes;
    }
    

    @Override
    public String toString() {
        return "SumarioAula{" +
                "titulo='" + titulo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", professor=" + (professor != null ? professor.getNome() : "null") +
                ", unidadeCurricular=" + (unidadeCurricular != null ? unidadeCurricular.getDesignacao() : "null") +
                '}';
    }
}

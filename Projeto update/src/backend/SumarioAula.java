package backend;

import java.io.Serializable;

public class SumarioAula implements Serializable{
    private String titulo;
    private String tipo;
    private String sumario;
    private Professor professor;
    private UnidadeCurricular unidadeCurricular;

    public SumarioAula(){
        
    }
    
    public SumarioAula(String titulo, String tipo, String sumario, Professor professor, UnidadeCurricular unidadeCurricular) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.sumario = sumario;
        this.professor = professor;
        this.unidadeCurricular = unidadeCurricular;
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

    @Override
    public String toString() {
        return "SumarioAula{" + "titulo=" + titulo + 
                ", tipo=" + tipo + ", sumario=" + sumario + ", professor=" + 
                professor + ", unidadeCurricular=" + unidadeCurricular + '}';
    }
    
    
    
}

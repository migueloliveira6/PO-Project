package backend;

import java.util.ArrayList;

public class UnidadeCurricular {
    private String designacao;
    private Professor regente;
    private ArrayList<Professor> equipaDocente;
    private ArrayList<SumarioAula> sumariosAula;

    public UnidadeCurricular() {
    }
 
    public UnidadeCurricular(String designacao, Professor regente, ArrayList<Professor> equipaDocente, ArrayList<SumarioAula> sumariosAula) {
        this.designacao = designacao;
        this.regente = regente;
        this.equipaDocente = equipaDocente;
        this.sumariosAula = sumariosAula;
    }

    public String getDesignacao() {
        return designacao;
    }

    public Professor getRegente() {
        return regente;
    }

    public ArrayList<Professor> getEquipaDocente() {
        return equipaDocente;
    }

    public ArrayList<SumarioAula> getSumariosAula() {
        return sumariosAula;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setRegente(Professor regente) {
        this.regente = regente;
    }

    public void setEquipaDocente(ArrayList<Professor> equipaDocente) {
        this.equipaDocente = equipaDocente;
    }

    public void setSumariosAula(ArrayList<SumarioAula> sumariosAula) {
        this.sumariosAula = sumariosAula;
    }
   
    
}

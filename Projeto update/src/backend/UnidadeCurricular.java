package backend;

import java.io.Serializable;
import java.util.ArrayList;

public class UnidadeCurricular implements Serializable{
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
    
    public void atribuirRegencia(Professor professor) {
        this.regente = professor;
        System.out.println("Regência atribuída com sucesso!");
    }

    public void adicionarProfessorEquipaDocente(Professor professor) {
        if (equipaDocente == null) {
            equipaDocente = new ArrayList<>();
        }
        equipaDocente.add(professor);
        System.out.println("Professor adicionado à equipe docente com sucesso!");
    }

    public void removerProfessorEquipaDocente(Professor professor) {
        if (equipaDocente != null) {
            equipaDocente.remove(professor);
            System.out.println("Professor removido da equipe docente com sucesso!");
        } else {
            System.err.println("Equipe docente não existe.");
        }
    }

    @Override
    public String toString() {
        return "UnidadeCurricular{" + "designacao=" + designacao + 
         ", regente=" + regente + ", equipaDocente=" + equipaDocente + ", sumariosAula=" + sumariosAula + '}';
    }
    
    
}

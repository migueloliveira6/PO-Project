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
    
    public void adicionarSumUC(SumarioAula sum) {
        if (sumariosAula == null) {
            sumariosAula = new ArrayList<>();
        }
        sumariosAula.add(sum);
        System.out.println("Sumário adicionado à UC com sucesso!");
    }
    
    public void removerSumUC(SumarioAula sum) {
        if (sumariosAula != null) {
            sumariosAula.remove(sum);
            System.out.println("Sumário removido da UC com sucesso!");
        }else{
            System.out.println("Sumário não existe.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UnidadeCurricular{designacao=").append(designacao);

        if (regente != null) {
            sb.append(", regente=").append(regente.getNome());
        } else {
            sb.append(", regente=null");
        }

        sb.append(", equipaDocente=[");
        if (equipaDocente != null && !equipaDocente.isEmpty()) {
            for (Professor professor : equipaDocente) {
                sb.append(professor.getNome()).append(", ");
            }
            sb.setLength(sb.length() - 2); // Remover a vírgula extra no final
        }

        sb.append("], sumariosAula=").append(sumariosAula).append('}');
        return sb.toString();
    }
}
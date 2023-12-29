
package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Professor implements Serializable{
    private String nome;
    private int numMecanografico;
    private LocalDate dataInicioFuncoes;
    private List<UnidadeCurricular> unidadesCurriculares;
    private String password;
    private Curso curso;
    private boolean diretorcurso;
    private boolean regente;
    
    public boolean autenticar(int numMecanografico, String password) {
        return this.numMecanografico == numMecanografico &&
            this.password.equals(password);
    }
    
    public Professor(){
    }

    public Professor(String nome, int numMecanografico, LocalDate dataInicioFuncoes, String username, String password) {
        this.nome = nome;
        this.numMecanografico = numMecanografico;
        this.dataInicioFuncoes = dataInicioFuncoes;
        this.password = password;
    }

    
    public String getNome() {
        return nome;
    }

    public int getNumMecanografico() {
        return numMecanografico;
    }

    public LocalDate getDataInicioFuncoes() {
        return dataInicioFuncoes;
    }

    public List<UnidadeCurricular> getUnidadesCurriculares() {
        return unidadesCurriculares;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setNumMecanografico(int numMecanografico) {
        this.numMecanografico = numMecanografico;
    }

    public void setDataInicioFuncoes(LocalDate dataInicioFuncoes) {
        this.dataInicioFuncoes = dataInicioFuncoes;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUnidadesCurriculares(List<UnidadeCurricular> unidadesCurricular) {
        this.unidadesCurriculares = unidadesCurricular;
    }
    
    public void adicionarUCaoProf(UnidadeCurricular uc) {
        if (unidadesCurriculares == null) {
            unidadesCurriculares = new ArrayList<>();
        }
        unidadesCurriculares.add(uc);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Professor{nome=").append(nome).append(", numMecanografico=").append(numMecanografico)
            .append(", dataInicioFuncoes=").append(dataInicioFuncoes).append(", unidadesCurriculares=[");

        if (unidadesCurriculares != null && !unidadesCurriculares.isEmpty()) {
            for (UnidadeCurricular uc : unidadesCurriculares) {
                sb.append(uc.getDesignacao()).append(", ");
            }
            sb.setLength(sb.length() - 2); // remove a virgula extra no final
        }

        sb.append("], diretorcurso=").append(diretorcurso).append(", regente=").append(regente)
            .append(", curso=").append(curso != null ? curso.getDesignacao() : "null")
            .append(", password=").append(password).append('}');
        return sb.toString();
    }

    public boolean isDiretorDeCurso() {
        return diretorcurso;
    }
    
    public void setDiretorDeCurso(boolean diretorDeCurso) {
        this.diretorcurso = diretorDeCurso;
    }
    
    public boolean isRegente() {
        return regente;
    }
    
    public void setRegente(boolean regente) {
        this.regente = regente;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}

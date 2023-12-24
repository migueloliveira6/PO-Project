
package backend;

import java.io.Serializable;
import java.util.List;

public class Professor implements Serializable{
    private String nome;
    private int numMecanografico;
    private String dataInicioFuncoes;
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

    public Professor(String nome, int numMecanografico, String dataInicioFuncoes, String username, String password) {
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

    public String getDataInicioFuncoes() {
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

    public void setDataInicioFuncoes(String dataInicioFuncoes) {
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

    @Override
    public String toString() {
        return "Professor{" + "nome=" + nome + ", numMecanografico=" + numMecanografico + ","
                + " dataInicioFuncoes=" + dataInicioFuncoes + ", unidadesCurriculares=" + 
                unidadesCurriculares + '}';
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

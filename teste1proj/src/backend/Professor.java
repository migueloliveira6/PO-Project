
package backend;

import java.util.List;

public class Professor {
    private String nome;
    private int numMecanografico;
    private String dataInicioFuncoes;
    private List<UnidadeCurricular> unidadesCurriculares;
    private String password;
    
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

    public void setNome(String nome) {
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
}

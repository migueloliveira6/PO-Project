package backend;

import java.io.Serializable;

public class Aluno implements Serializable{

    private String nome;
    private int numeromecanografico;
    private Curso curso;

    public Aluno() {
    }
    
    public Aluno(String nome, int numeromecanografico, Curso curso) {
        this.nome = nome;
        this.numeromecanografico = numeromecanografico;
        this.curso = curso;
    }

    public String getnome() {
        return nome;
    }

    public int getnumeromecanografico() {
        return numeromecanografico;
    }

    public Curso getcurso() {
        return curso;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public void setnumeromecanografico(int numeromecanografico) {
        this.numeromecanografico = numeromecanografico;
    }

    public void setcurso(Curso curso) {
        this.curso = curso;
    }
    
    public void removerCurso() {
        this.curso = null;
        System.out.println("Curso removido do aluno com sucesso!");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aluno{nome=").append(nome);
        sb.append(", numeromecanografico=").append(numeromecanografico);

        // Adicione informações específicas sobre o curso
        if (curso != null) {
            sb.append(", curso=").append(curso.getDesignacao());
        } else {
            sb.append(", curso=null");
        }

        sb.append('}');
        return sb.toString();
    }
}

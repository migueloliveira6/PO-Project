package backend;

public class Aluno {

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

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", numeromecanografico=" + numeromecanografico + ", curso=" + curso + '}';
    }

    

    
    
    
}

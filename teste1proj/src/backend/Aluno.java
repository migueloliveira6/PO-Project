package backend;

public class Aluno {

    private String nome;
    private int numeromecanografico;
    private Curso curso;
    private String username;
    private String password;

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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    
}

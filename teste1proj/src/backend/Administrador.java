package backend;
import java.util.Scanner;
import java.util.List;
import frontend.Menu_Administrador;

public class Administrador {
    
    Scanner read = new Scanner(System.in);
    private final String username = "adm";
    private final String password = "0000";
    
    public boolean autenticar(String username, String password) {
        return this.username.equals(username) && 
                this.password.equals(password);
    }
    
    public Administrador(){

    }

    public void atribuirDirecaoCurso(Professor professor, Curso curso) {
        if (curso != null) {
            curso.setDiretorCurso(professor);
            System.out.println("Direção do curso atribuída com sucesso!");
        } else {
            System.out.println("Erro: Curso não encontrado.");
        }
        //Menu_Administrador.menu();
    }

     public void atribuirRegenciaUC(UnidadeCurricular unidadeCurricular, Professor professor) {
        if (unidadeCurricular != null) {
            unidadeCurricular.setRegente(professor);
            System.out.println("Regência da UC atribuída com sucesso!");
        } else {
            System.out.println("Erro: Unidade Curricular não encontrada.");
        }
        //Menu_Administrador.menu();
    }
}

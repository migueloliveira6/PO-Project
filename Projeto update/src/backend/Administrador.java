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

    public void atribuirDirecaoCurso(ListaProfessores profs, ListaCursos cursos) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Professores disponíveis:");
        profs.listarProfessores();

        System.out.println("Cursos disponíveis:");
        cursos.listarCursos(); 

        System.out.print("Digite o número mecanográfico do professor que será diretor de curso: ");
        int numMecanografico = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Digite o nome do curso para o qual deseja atribuir a direção: ");
        String nomeCurso = scanner.nextLine();

        Professor professor = profs.getProfessorByNumMecanografico(numMecanografico);
        Curso curso = cursos.getCursoByNome(nomeCurso);

        if (professor != null && curso != null) {
            curso.setDiretorCurso(professor);
            professor.setDiretorDeCurso(true);
            System.out.println("Direção do curso atribuída com sucesso!");
        } else {
            System.out.println("Erro: Professor ou curso não encontrado.");
        }
}

     public void atribuirRegenciaUC(ListaProfessores profs, ListaUC ucs) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Professores disponíveis:");
        profs.listarProfessores();  

        System.out.println("UCs disponíveis:");
        ucs.listarUCs();

        System.out.print("Digite o número mecanográfico do professor que será diretor de curso: ");
        int numMecanografico = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Digite o nome da unidade curricular para o qual deseja atribuir a regência: ");
        String nomeUC = scanner.nextLine();

        Professor professor = profs.getProfessorByNumMecanografico(numMecanografico);
        UnidadeCurricular uc = ucs.getUCByNome(nomeUC);

        if (professor != null && uc != null) {
            uc.atribuirRegencia(professor);
            professor.setRegente(true);
        } else {
            System.out.println("Erro: Professor ou curso não encontrado.");
        }
 }
}

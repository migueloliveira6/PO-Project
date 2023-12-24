
package frontend;
import backend.Curso;
import backend.ListaAluno;
import backend.ListaCursos;
import backend.ListaProfessores;
import backend.Professor;
import java.util.Map;
import java.util.Scanner;
public class Menu_Diretor {
    
    private static Professor authenticarPorNumMecanografico(ListaProfessores profs, int numMecanograficoProf, String pass) {
    Professor professorParaAuth = null;

    for (Professor professor : profs.getLista()) {
        if (professor.getNumMecanografico() == numMecanograficoProf) {
            professorParaAuth = professor;
            break;
        }
    }

    if (professorParaAuth != null && professorParaAuth.autenticar(numMecanograficoProf, pass)) {
        return professorParaAuth;
    }
    return null;
}
    
    public static void authdiretor(ListaProfessores profs, ListaCursos cursos, ListaAluno alunos) {
    Scanner read = new Scanner(System.in);
    
    System.out.println("Introduza o seu número mecanográfico:");
    int numMecanografico = read.nextInt();
    read.nextLine(); 

    System.out.println("Introduza a sua senha:");
    String senha = read.nextLine();

    Professor dirAutenticado = authenticarPorNumMecanografico(profs, numMecanografico, senha);

    if (dirAutenticado != null && dirAutenticado.isDiretorDeCurso()) {
        Curso cursoDoDiretor = encontrarCursoDoDiretor(cursos, dirAutenticado);

        if (cursoDoDiretor != null) {
            System.out.println("Bem-vindo, Diretor de Curso do curso: " + cursoDoDiretor.getDesignacao());
            Menu_Diretor.menudir(profs, cursos, dirAutenticado, cursoDoDiretor, alunos);
        } else {
            System.err.println("Erro: Diretor de curso não associado a nenhum curso.");
        }
    } else {
        System.err.println("Autenticação falhou. Tente novamente.");
    }
}

    private static Curso encontrarCursoDoDiretor(ListaCursos cursos, Professor diretor) {
        for (Curso curso : cursos.getListaCurso()) {
            if (curso.getDiretorCurso() != null && curso.getDiretorCurso().equals(diretor)) {
                return curso;
            }
        }
        return null;
    }
    
    public static void menudir(ListaProfessores profs, ListaCursos cursos, Professor dir, Curso curso, ListaAluno listaAlunos){
                int opcaoDiretor = -1;
                Scanner opc = new Scanner(System.in);
                while(opcaoDiretor != 0){
                    
                    System.out.print("\033[H\033[2J"); 
                    System.out.flush();                     
                    System.out.println("**************************************************************************");
                    System.out.println( "*            Bem vindo as opcoes de Diretor de curso, "+dir.getNome()+"!  *");
                    System.out.println("*   O que pretende fazer?                                                *");
                    System.out.println("* 1-> Alterar designação do curso                                        *");
                    System.out.println("* 2-> Listar alunos por curso                                            *");
                    System.out.println("* 3-> Listar professores por curso                                       *");
                    System.out.println("* 0-> Voltar ao Menu Inicial                                             *");
                    System.out.println("**************************************************************************");
                    opcaoDiretor = opc.nextInt();

                    switch(opcaoDiretor){
                        case 1:
                            System.out.println("Alteração da designação do curso: ");
                            cursos.alterarCursoinfoDiretor(curso);
                            break;
                        case 2:
                            System.out.println("Lista de alunos por curso: ");
                            Map<Curso, Integer> numeroAlunosPorCurso = listaAlunos.getNumeroAlunosPorCurso();
                                for (Map.Entry<Curso, Integer> entry : numeroAlunosPorCurso.entrySet()) {
                                    System.out.println("Curso: " + entry.getKey().getDesignacao()+ ", Número de Alunos: " + entry.getValue());
                                }
                            break;
                        case 3:
                            System.out.println("Lista de professores por curso: ");
                            Map<Curso, Integer> numeroProfsPorCurso = profs.getNumeroProfessoresPorCurso();
                            if (numeroProfsPorCurso != null){
                            for (Map.Entry<Curso, Integer> entry : numeroProfsPorCurso.entrySet()) {
                                    System.out.println("Curso: " + entry.getKey().getDesignacao()+ ", Número de Professores: " + entry.getValue());
                                }
                            }else{
                                System.err.println("Não existe nenhum professor associado a nenhum curso!");
                            } 
                            break;
                        case 0:
                            System.out.println("A voltar ao menu inicial...");
                            break;

                        default:
                            System.out.println("ERRO NA INTRODUCAO DA OPCAO");
                            break;
                    }
             }            
          }
    }
    


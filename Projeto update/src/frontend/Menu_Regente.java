
package frontend;
import backend.Aluno;
import backend.Curso;
import backend.ListaAluno;
import backend.UnidadeCurricular;
import backend.ListaProfessores;
import backend.ListaUC;
import backend.Professor;
import java.util.Scanner;

public class Menu_Regente {
    
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
    
    public static void authregente(ListaProfessores profs, ListaUC ucs, ListaAluno alunos) {
    Scanner read = new Scanner(System.in);
    
    System.out.println("Introduza o seu número mecanográfico:");
    int numMecanografico = read.nextInt();
    read.nextLine(); 

    System.out.println("Introduza a sua senha:");
    String senha = read.nextLine();

    Professor regAutenticado = authenticarPorNumMecanografico(profs, numMecanografico, senha);

    if (regAutenticado != null && regAutenticado.isRegente()) {
        UnidadeCurricular ucDoregente = encontrarUCDoRegente(ucs, regAutenticado);

        if (ucDoregente != null) {
            System.out.println("Bem-vindo, Regente da UC: " + ucDoregente.getDesignacao());
            Curso curso = obterCursoDoRegente(regAutenticado);
            Menu_Regente.menureg(profs, ucs, alunos, regAutenticado, ucDoregente, curso);
        } else {
            System.err.println("Erro: Regente não associado a nenhuma UC.");
        }
    } else {
        System.err.println("Autenticação falhou. Tente novamente.");
    }
}

    private static UnidadeCurricular encontrarUCDoRegente(ListaUC ucs, Professor regente) {
        for (UnidadeCurricular uc : ucs.getListaUC()) {
            if (uc.getRegente() != null && uc.getRegente().equals(regente)) {
                return uc;
            }
        }
        return null;
    }
    
    public static Curso obterCursoDoRegente(Professor regente) {
        Curso cursoAssociado = regente.getCurso();

        if (cursoAssociado != null) {
            return cursoAssociado;
        } else {
            return null;
        }
    }
    
    
    public static void menureg(ListaProfessores profs, ListaUC ucs,ListaAluno alunos, Professor reg, UnidadeCurricular uc, Curso curso){
                int opcaoRegente = -1;
                Scanner opc = new Scanner(System.in);
                while(opcaoRegente != 0){
                System.out.print("\033[H\033[2J"); 
                System.out.flush();
                System.out.println("**************************************************************************");
                System.out.println("*                Bem vindo as opcoes de Regente, "+reg.getNome()+"!        *");
                System.out.println("*   O que pretende fazer?                                                *");
                System.out.println("* 1-> Adicionar alunos do Curso                                          *");
                System.out.println("* 2-> Remover alunos do Curso                                            *");
                System.out.println("* 3-> Consultar assiduidade de determinado aluno                         *");
                System.out.println("* 0-> Voltar ao Menu Inicial                                             *");
                System.out.println("**************************************************************************");
                opcaoRegente = opc.nextInt();
                opc.nextLine();
                
                switch(opcaoRegente){
                    case 1: 
                        System.out.println("Adicionar aluno ao Curso: ");
                        System.out.println("Insira o NumMecan do aluno:");
                        int numMecan = opc.nextInt();
                        opc.nextLine();
                        Aluno aluno = alunos.getAlunoByNumMecanico(numMecan);
                        curso.adicionarAlunoaoCurso(aluno);
                        break;
                    case 2:
                        System.out.println("Remover aluno ao Curso: ");
                        System.out.println("Insira o NumMecan do aluno:");
                        int numMecano = opc.nextInt();
                        opc.nextLine();
                        Aluno aluno1 = alunos.getAlunoByNumMecanico(numMecano);
                        curso.removerAlunoDoCurso(aluno1);
                        break;
                    case 3:
                        System.out.println("Consulta de assiduidade: ");
                        
                        break;
                        
                    case 0:
                        System.out.println("A voltar ao menu inicial...");
                        break;
                        
                    default:
                        System.out.println("ERRO NA INTRODUCAO DA OPCAO");
                        break;
                }
                break;
                }         
    }
}


package frontend;
import backend.Aluno;
import backend.Curso;
import backend.ListaAluno;
import backend.UnidadeCurricular;
import backend.ListaProfessores;
import backend.ListaSumario;
import backend.ListaUC;
import backend.Professor;
import backend.SumarioAula;

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
    
    public static void authregente(ListaProfessores profs, ListaUC ucs, ListaAluno alunos, Consola consola, ListaSumario sums) {

        System.out.println("Introduza o seu número mecanográfico:");
        int numMecanografico = consola.lerInteiro();

        System.out.println("Introduza a sua senha:");
        String senha = consola.lerString();

        Professor regAutenticado = authenticarPorNumMecanografico(profs, numMecanografico, senha);

        if (regAutenticado != null && regAutenticado.isRegente()) {
            UnidadeCurricular ucDoregente = encontrarUCDoRegente(ucs, regAutenticado);

            if (ucDoregente != null) {
                System.out.println("Bem-vindo, Regente da UC: " + ucDoregente.getDesignacao());
                Curso curso = obterCursoDoRegente(regAutenticado);
                Menu_Regente.menureg(profs, ucs, alunos, regAutenticado, ucDoregente, curso, consola, sums);
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
    
    
    public static void menureg(ListaProfessores profs, ListaUC ucs,ListaAluno alunos, Professor reg, UnidadeCurricular uc, Curso curso, Consola consola, ListaSumario sums){
        
                int opcaoRegente = -1;
                while(opcaoRegente != 0){
                //System.out.print("\033[H\033[2J"); 
                //System.out.flush();
                System.out.println("**************************************************************************");
                System.out.println("*                Bem vindo as opcoes de Regente, "+reg.getNome()+"!        *");
                System.out.println("*   O que pretende fazer?                                                *");
                System.out.println("* 1-> Adicionar alunos ao Curso                                          *");
                System.out.println("* 2-> Remover alunos do Curso                                            *");
                System.out.println("* 3-> Consultar assiduidade de determinado aluno                         *");
                System.out.println("* 0-> Voltar ao Menu Inicial                                             *");
                System.out.println("**************************************************************************");
                opcaoRegente = consola.lerInteiro();
                
                switch(opcaoRegente){
                    case 1: 
                        System.out.println("Adicionar aluno ao Curso: ");
                        System.out.println("Insira o NumMecan do aluno:");
                        int numMecano = consola.lerInteiro();

                        Aluno aluno1 = alunos.getAlunoByNumMecanico(numMecano);

                        if (aluno1 != null) {
                            curso.adicionarAlunoaoCurso(aluno1);
                            aluno1.setcurso(curso);
                            System.out.println("Aluno adicionado ao curso com sucesso!");
                        } else {
                            System.err.println("Aluno não encontrado. Não foi possível adicioná-lo ao curso.");
                        }
                        break;
                    case 2:
                        System.out.println("Remover aluno ao Curso: ");
                        System.out.println("Insira o NumMecan do aluno:");
                        int numMecanog = consola.lerInteiro();

                        Aluno aluno2 = alunos.getAlunoByNumMecanico(numMecanog);

                        if (aluno2 != null) {
                            curso.removerAlunoDoCurso(aluno2);
                            aluno2.removerCurso();
                            System.out.println("Aluno removido do curso com sucesso!");
                        } else {
                            System.err.println("Aluno não encontrado. Não foi possível remover do curso.");
                        }
                        break;
                    case 3:
                        System.out.println("Consulta de assiduidade: ");
                        listarAssiduidade(sums);
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
    
    public static void listarAssiduidade(ListaSumario sums) {

        for (SumarioAula sum : sums.getLista()) {
            System.out.println("Titulo do sumário: " + sum.getTitulo());

            System.out.println("Alunos presentes nessa aula:");
            for (Aluno aluno : sum.getAlunosPresentes()) {
                System.out.println(aluno.getnome() + "\n");
            }
        }
    }
}
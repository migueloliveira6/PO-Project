
package frontend;
import backend.Aluno;
import backend.ListaAluno;
import backend.ListaProfessores;
import backend.ListaSumario;
import backend.ListaUC;
import backend.Professor;
import backend.SumarioAula;
import backend.UnidadeCurricular;
import java.util.List;

public class Menu_Professor{
    
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
    
   public static void authprof(ListaProfessores profs, ListaSumario sums, ListaUC ucs, Consola consola, ListaAluno alunos) {

        Professor profAutenticado;

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("**************************************************************************");
        System.out.println("*                      Digite o seu numero mecan e password!                 *");
        System.out.println("**************************************************************************");

        System.out.print("O numero mecanografico do professor: ");
        int numMecanografico = consola.lerInteiro();

        System.out.print("Senha: ");
        String senha = consola.lerString();

        profAutenticado = authenticarPorNumMecanografico(profs, numMecanografico, senha);

        if (profAutenticado != null) {
            System.out.println("Autenticação bem-sucedida para " + profAutenticado.getNome() + "!");
            Menu_Professor.menu(profs, sums, profAutenticado, ucs, consola, alunos);
        } else {
            System.out.println("Credenciais inválidas. Tente novamente.");
            return;
        }
    }
    public static void menu(ListaProfessores listap, ListaSumario sums, Professor profAutenticado, ListaUC ucs, Consola consola, ListaAluno alunos){
         int opcaoPro = -1;
                while(opcaoPro != 0){
                System.out.print("\033[H\033[2J"); 
                System.out.flush(); 
                System.out.println("**************************************************************************");
                System.out.println("*                   Bem vindo "+profAutenticado.getNome()+"!               *");
                System.out.println("*   O que pretende fazer?                                                *");
                System.out.println("* 1-> Criar Sumario                                                      *");
                System.out.println("* 2-> Consultar lista de sumarios por UC e tipo de aula                  *");
                System.out.println("* 3-> Consultar serviço docente                                          *");
                System.out.println("* 0-> Voltar ao Menu Inicial                                             *");
                System.out.println("**************************************************************************");
                opcaoPro = consola.lerInteiro();
                         
                switch(opcaoPro){
                    case 1:
                        System.out.println("Criacao de sumarios: ");
                        Menu_Professor.criarSum(profAutenticado, ucs, sums, consola, alunos);
                        break;
                    case 2:
                        System.out.println("Lista de sumarios: ");
                        System.out.println("Insira o tipo de aula que deseja consultar:");
                        String tipoAula = consola.lerString();
                        System.out.println("Insira a UC que deseja consultar:");
                        String nomeUC = consola.lerString();
                        UnidadeCurricular uc = ucs.getUCByNome(nomeUC);
                        sums.consultarSumariosPorUCeTipoAula(uc, tipoAula);
                        break;
                    case 3:
                        System.out.println("Servico docente: ");
                        Menu_Professor.consultarServicoDocente(profAutenticado);
                        break;
                    case 0:
                        System.out.println("A voltar para menu inicial...");
                        break;
                    default:
                        System.out.println("ERRO NA INTRODUCAO DA OPCAO");
                        break;
                }
            }
    }
    
    public static void consultarServicoDocente(Professor prof) {
        System.out.println("Consulta de Serviço Docente:");

            System.out.println("Nome do Professor: " + prof.getNome());
            System.out.println("Número Mecanográfico: " + prof.getNumMecanografico());
            System.out.println("Unidades Curriculares Participante:");

            List<UnidadeCurricular> unidadesCurriculares = prof.getUnidadesCurriculares();
            if (unidadesCurriculares.isEmpty()) {
                System.err.println("Nenhuma unidade curricular atribuída.");
            } else {
                for (UnidadeCurricular uc : unidadesCurriculares) {
                    System.out.println("- " + uc.getDesignacao());
                }
            }

            System.out.println("------------------------------");
    }
    
    public static void criarSum(Professor prof, ListaUC listaUC, ListaSumario sums, Consola consola, ListaAluno alunos) {

        System.out.println("Introduza o título do sumário:");
        String titulo = consola.lerString();

        System.out.println("Introduza o tipo de aula: (T, TP, PL)");
        String tipo = consola.lerString();

        System.out.println("Introduza o sumário:");
        String sumario = consola.lerString();

        System.out.println("Alunos presentes:");
        alunos.listarAlunos();
        System.out.println("\nNúmero de alunos presentes na aula:");
        int numAlunosPresentes = consola.lerInteiro();

        // Criar instância de SumarioAula após obter informações do sumário
        SumarioAula sum = new SumarioAula(titulo, tipo, sumario, prof, null);

        for (int i = 0; i < numAlunosPresentes; i++) {
            System.out.println("Introduza o número mecanográfico do/dos aluno/os presente/s:");
            int numMecanicoAluno = consola.lerInteiro();
            Aluno alunoPresente = alunos.getAlunoByNumMecanico(numMecanicoAluno);

            if (alunoPresente != null) {
                sum.adicionarAlunoPresente(alunoPresente);
            } else {
                System.err.println("Aluno não encontrado. O aluno não será adicionado à lista de presentes.");
            }
        }

        System.out.println("Indique qual a UC que pertence este sumário:");
        listaUC.listarUCs();
        System.out.println("\nOpcao:");
        String designacaoUC = consola.lerString();
        UnidadeCurricular uc = listaUC.getUCByNome(designacaoUC);

        if (uc != null) {
            sum.setUnidadeCurricular(uc);
            uc.adicionarSumUC(sum);
            sums.inserir(sum);
            System.out.println("Sumário criado com sucesso!");
        } else {
            System.err.println("UC não encontrada. O sumário não terá nenhuma UC associada.");
        }
    }
}
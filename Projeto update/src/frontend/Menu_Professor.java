
package frontend;
import backend.ListaProfessores;
import backend.ListaSumario;
import backend.ListaUC;
import backend.Professor;
import backend.SumarioAula;
import backend.UnidadeCurricular;
import java.util.Scanner;
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
    
   public static void authprof(ListaProfessores profs, ListaSumario sums, ListaUC ucs) {
        Scanner scanner = new Scanner(System.in);
        Professor profAutenticado;

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("**************************************************************************");
        System.out.println("*                      Digite o seu numero mecan e password!                 *");
        System.out.println("**************************************************************************");

        System.out.print("O numero mecanografico do professor: ");
        int numMecanografico = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        profAutenticado = authenticarPorNumMecanografico(profs, numMecanografico, senha);

        if (profAutenticado != null) {
            System.out.println("Autenticação bem-sucedida para " + profAutenticado.getNome() + "!");
            Menu_Professor.menu(profs, sums, profAutenticado, ucs);
        } else {
            System.out.println("Credenciais inválidas. Tente novamente.");
            return;
        }
    }
    public static void menu(ListaProfessores listap, ListaSumario sums, Professor profAutenticado, ListaUC ucs){
         int opcaoPro = -1;
         Scanner opc = new Scanner (System.in);
                while(opcaoPro != 0){
                System.out.print("\033[H\033[2J"); 
                System.out.flush(); 
                System.out.println("**************************************************************************");
                System.out.println("*                   Bem vindo "+profAutenticado.getNome()+"!               *");
                System.out.println("*   O que pretende fazer?                                                *");
                System.out.println("* 1-> Criar Sumario                                                      *");
                System.out.println("* 2-> Consultar lista de sumarios por UC                                 *");
                System.out.println("* 3-> Consultar lista de sumarios por tipo de aula                       *");
                System.out.println("* 4-> Consultar serviço docente                                          *");
                System.out.println("* 0-> Voltar ao Menu Inicial                                             *");
                System.out.println("**************************************************************************");
                opcaoPro = opc.nextInt();
                         
                switch(opcaoPro){
                    case 1:
                        System.out.println("Criacao de sumarios: ");
                        sums.criarSum(profAutenticado, ucs);
                        break;
                    case 2:
                        System.out.println("Lista de sumarios: ");
                        System.out.println("Insira o tipo de aula que deseja consultar:");
                        String tipoAula = opc.next();
                        System.out.println("Insira a UC que deseja consultar:");
                        opc.nextLine();
                        String nomeUC = opc.nextLine();
                        UnidadeCurricular uc = ucs.getUCByNome(nomeUC);
                        sums.consultarSumariosPorUCeTipoAula(uc, tipoAula);
                        break;
                    case 3:
                        System.out.println("Servico docente: ");
                        listap.consultarServicoDocente(profAutenticado);
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
}
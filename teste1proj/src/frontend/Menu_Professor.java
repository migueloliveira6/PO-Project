
package frontend;
import backend.ListaProfessores;
import backend.Professor;
import backend.Sistema;
import java.util.List;
import java.util.Scanner;
public class Menu_Professor{
    
    private static boolean authenticarPorNumMecanografico(ListaProfessores listaProfessor, int numMecanograficoProf, String senha) {
        Professor professorParaAuth = null;
        for (Professor professor : listaProfessor.getListaProfessores()) {
        if (professor.getNumMecanografico() == numMecanograficoProf) {
            professorParaAuth = professor;
            break;
        }
    }

    if (professorParaAuth != null && professorParaAuth.autenticar(numMecanograficoProf, senha)) {
        return true;
    }
    return false;
}
    
    public static void authprof(ListaProfessores listaProfessores) {
        Scanner scanner = new Scanner(System.in);
        Professor prof = new Professor();

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("**************************************************************************");
        System.out.println("*                      Digite o seu username e password!                 *");
        System.out.println("**************************************************************************");

        System.out.print("O numero mecanografico do professor: ");
        int numMecanografico = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (authenticarPorNumMecanografico(listaProfessores, numMecanografico, senha)) {
            System.out.println("Autenticação bem-sucedida!");
            Menu_Professor.menu(listaProfessores);
        } else {
            System.out.println("Credenciais inválidas. Tente novamente.");
            return;
        }
    }
    public static void menu(ListaProfessores listaProfessores){
         int opcaoPro = -1;
         Scanner opc = new Scanner (System.in);
                while(opcaoPro != 0){
                System.out.print("\033[H\033[2J"); 
                System.out.flush(); 
                System.out.println("**************************************************************************");
                System.out.println("*                      Bem vindo as opcoes de PROF!                       *");
                System.out.println("*   O que pretende fazer?                                                *");
                System.out.println("* 1-> Criar Sumario                                                      *");
                System.out.println("* 2-> Consultar lista de sumarios por UC e por tipo de aula              *");
                System.out.println("* 3-> Consultar serviço docente                                          *");
                System.out.println("* 0-> Voltar ao Menu Inicial                                             *");
                System.out.println("**************************************************************************");
                opcaoPro = opc.nextInt();
                         
                switch(opcaoPro){
                    case 1:
                        System.out.println("Criacao de sumarios: ");
                        break;
                    case 2:
                        System.out.println("Lista de sumarios: ");
                        break;
                    case 3:
                        System.out.println("Servico docente: ");
                        break;
                    case 0:
                        System.out.println("A voltar para menu inicial...");
                        break;
                    default:
                        System.out.println("ERRO NA INTRODUCAO DA OPCAO");
                        break;
                }
                break;
                }
    }
}
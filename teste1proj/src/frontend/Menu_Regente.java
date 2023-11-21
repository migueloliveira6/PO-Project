
package frontend;
import java.util.Scanner;

public class Menu_Regente {
    public static void menu(){
                int opcaoRegente = -1;
                Scanner opc = new Scanner(System.in);
                while(opcaoRegente != 0){
                System.out.print("\033[H\033[2J"); 
                System.out.flush();
                System.out.println("**************************************************************************");
                System.out.println("*                      Bem vindo as opcoes de REG!                       *");
                System.out.println("*   O que pretende fazer?                                                *");
                System.out.println("* 1-> Adicionar, remover alunos do curso                                 *");
                System.out.println("* 2-> Consultar assiduidade de determinado aluno                         *");
                System.out.println("* 0-> Voltar ao Menu Inicial                                             *");
                System.out.println("**************************************************************************");
                opcaoRegente = opc.nextInt();
                
                switch(opcaoRegente){
                    case 1: 
                        System.out.println("Adicionar/remover alunos: ");
                        break;
                    case 2:
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

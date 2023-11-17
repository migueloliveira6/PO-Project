
package frontend;
import java.util.Scanner;
public class Menu_Diretor {
    
    public static void menu(){
                int opcaoDiretor = -1;
                Scanner opc = new Scanner(System.in);
                while(opcaoDiretor != 0){
                System.out.print("\033[H\033[2J"); 
                System.out.flush();                     
                System.out.println("**************************************************************************");
                System.out.println("*                      Bem vindo as opcoes de DIR!                       *");
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
                        break;
                    
                    case 2:
                        System.out.println("Lista de alunos por curso: ");
                        break;
                        
                    case 3:
                        System.out.println("Lista de professores por curso: ");
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
    


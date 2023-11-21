package frontend;
import java.util.Scanner;
import backend.Administrador;
import backend.ListaAluno;
import backend.ListaCursos;
import backend.ListaProfessores;
import backend.ListaUC;
public class Menu_Administrador{
    
    
    public static void auth(ListaCursos cursos, ListaUC ucs, ListaProfessores profs, ListaAluno alunos){
                Scanner scanner = new Scanner(System.in);
                Administrador administrador = new Administrador();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("**************************************************************************");
                    System.out.println("*                      Digite o seu username e password!                 *");
                    System.out.println("**************************************************************************");
                    
                    System.out.print("Nome de usuário: ");
                    String username = scanner.nextLine();
                    
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();
                    
                    if (administrador.autenticar(username, senha) == true){
                        System.out.println("Autenticação bem-sucedida!");
                        Menu_Administrador.menu(cursos,ucs,profs,alunos);
                    } else {
                        System.out.println("Credenciais inválidas. Tente novamente.");
                        return;
                    }
                } 
    
    public final static void clearConsole(){

        try{
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")){
                Runtime.getRuntime().exec("cls");

            }else{
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e){
        }
    }
    public static void menu(ListaCursos cursos, ListaUC ucs, ListaProfessores profs, ListaAluno alunos){
                int opcaoAdm = -1;
                Scanner opc = new Scanner(System.in);
                
                while(opcaoAdm!=0){
                clearConsole(); 
                System.out.flush(); 
                System.out.println("**************************************************************************");
                System.out.println("*                      Bem vindo as opcoes de ADM!                       *");
                System.out.println("*   O que pretende fazer?                                                *");
                System.out.println("----------------------------PROFESSORES----------------------------------*");
                System.out.println("* 1-> Criar professor                                                    *");
                System.out.println("* 2-> Remover professor                                                  *");
                System.out.println("* 3-> Alterar informação de professores                                  *");
		System.out.println("* 4-> Listar professores                                                 *");
		System.out.println("* 5-> Atribuir regência de UC a professor                                *");
		System.out.println("* 6 -> Atribuir direção de curso a professor                             *");
                System.out.println("-------------------------------CURSOS------------------------------------*");
		System.out.println("* 7-> Registar Curso                                                     *");
		System.out.println("* 8-> Alterar informação de Curso                                        *");
		System.out.println("* 9-> Listar cursos                                                      *");
		System.out.println("* 10-> Remover Curso                                                     *");
                System.out.println("-----------------------------UNIDADECURRICULAR---------------------------*");
		System.out.println("* 11-> Remover UC                                                        *");
		System.out.println("* 12-> Alterar informação de UC                                          *");
                System.out.println("* 13-> Listar UCs                                                        *");
		System.out.println("* 14-> Registar UC                                                       *");
                System.out.println("-------------------------------ALUNOS------------------------------------*");
		System.out.println("* 15-> Criar aluno                                                       *");
                System.out.println("* 16-> Listar alunos                                                     *");
		System.out.println("* 17-> Remover aluno                                                     *");
                System.out.println("* 18-> Alterar informação do Aluno                                       *");
                System.out.println("* 0-> Voltar ao Menu Inicial                                             *");
                System.out.println("**************************************************************************");
                opcaoAdm = opc.nextInt();
                         
                switch(opcaoAdm){
                    
                    case 1: 
                        System.out.println("Criar professor: ");
                        profs.criarProfessor();
                        break;                
                    case 2:
                        System.out.println("Remover professor: ");
                        profs.apagarProfessor();
                        break;
                    case 3:
                        System.out.println("Alteracao de informacao de professores : ");
                        profs.alterarInformacaoProfessor();
                        break;
                    case 4: 
			System.out.println("Listar professores: ");
                        profs.listarProfessores();
                        break;                  
                    case 5: 
			System.out.println("Atribuir regência de UC a professor: ");
			break;
                    case 6: 
			System.out.println("Atribuir direção de curso a professor: ");
			break;
                    case 7: 
			System.out.println("Registar Curso: ");
                        cursos.registarCurso();
                        break;					
                    case 8:
			System.out.println("Alterar informacao do curso: ");
                        cursos.alterarInformacaoCurso();
                        break;                  
                    case 9:
			System.out.println("Listar Cursos: ");
                        cursos.listarCursos();
                        break;					                       	
                    case 10:
                        System.out.println("Remover Curso: ");
                        cursos.apagarCurso();
                        break;	
                    case 11:
                        System.out.println("Remover UC: ");
                        ucs.apagarUC();
			break;
                    case 12:
			System.out.println("Alterar informacao da UC: ");
                        ucs.alterarInformacaoUC();
                        break;	
                    case 13:
                        System.out.println("Listar UCs: ");
                        ucs.listarUCs();
                        break;					
                    case 14: 
			System.out.println("Registar UC: ");
                        ucs.registarUC();
                        break;					
                    case 15:
			System.out.println("Criar aluno: ");
                        alunos.criarAluno();
			break;
                    case 16:
			System.out.println("Listar alunos: ");
                        alunos.listarAlunos();
                        break;
                    case 17:
                        System.out.println("Remover aluno: ");
                        alunos.apagarAluno();
                        break;
                    case 18:
                        System.out.println("Alterar informacao do Aluno: ");
                        alunos.alterarInformacaoAluno();
                        break;
                    case 0:  
                        System.out.println("A voltar para o menu inicial...");
                        opc.nextLine();
                        break;
                    default: 
                        System.out.println("ERRO NA INTRODUCAO DA OPCAO");
                        break;
                    }
                }
    }
}
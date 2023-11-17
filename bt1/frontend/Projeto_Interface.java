package frontend;

import backend.ListaProfessores;
import backend.Professor;
import java.util.List;
import java.util.Scanner;

public class Projeto_Interface {
    public static void main(String[] args) {
        Scanner opcao = new Scanner(System.in);
        //ListaProfessores listaProfessor = new ListaProfessores();
            int option = 9;

            do{
                System.out.println("***********************");
                System.out.println("Bem-vindo ao DEP da Universidade do Minho");
                System.out.println("Introduza qual a sua função na Universidade: ");
                System.out.println("1-> Administrador");
                System.out.println("2-> Professor");
                System.out.println("3-> Regente da UC");
                System.out.println("4-> Diretor de Curso");
                System.out.println("9-> Sair do Programa");
                System.out.println("***********************");

                    option = opcao.nextInt();

                    switch (option) {
                        case 1: Menu_Administrador.auth();
                                break;
                        case 2: 
                        Menu_Professor.authprof();
                            
                        break;

                        case 3: Menu_Diretor.menu();
                                break;
                        case 4: Menu_Regente.menu();
                                break;
                        case 9: System.out.println("Programa encerrado. Até logo!");
                                break;
                        default: System.out.println("Opção Inválida. Tente novamente.");
                    }
            }while (option != 9) ;
        }
    }

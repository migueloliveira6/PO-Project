package frontend;

import backend.FicheirosArm;
import backend.ListaAluno;
import backend.ListaCursos;
import backend.ListaProfessores;
import backend.ListaSumario;
import backend.ListaUC;
import backend.Sistema;
import java.util.Scanner;


public class Projeto_Interface {
    
    public static void main(String[] args) throws Exception {
        
        Scanner opcao = new Scanner(System.in);
        Sistema sistem = new Sistema();

        ListaCursos cursos = sistem.getListaCursos();
        ListaUC ucs = sistem.getListaUC();
        ListaProfessores profs = sistem.getListaProfessores();
        ListaAluno alunos = sistem.getListaAluno();
        ListaSumario sums = sistem.getListasumarios();

        // Carregar dados do arquivo
        //sistem.carregarDados();

        int option = 9;

        do {
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
                case 1:
                    Menu_Administrador.auth(cursos, ucs, profs, alunos, sistem);
                    break;
                case 2:
                    Menu_Professor.authprof(profs, sums, ucs);
                    break;
                case 3:
                    Menu_Regente.authregente(profs, ucs, alunos);
                    break;
                case 4:
                    Menu_Diretor.authdiretor(profs, cursos, alunos);
                    break;
                case 9:
                    System.out.println("A guardar dados...");
                    // Salvar dados no arquivo
                    
                    //sistem.guardarDados();
                    break;
                default:
                    System.out.println("Opção Inválida. Tente novamente.");
            }
        } while (option != 9);
    }
}

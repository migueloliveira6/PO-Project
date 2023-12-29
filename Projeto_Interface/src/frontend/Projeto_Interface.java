package frontend;

import backend.ListaAluno;
import backend.ListaCursos;
import backend.ListaProfessores;
import backend.ListaSumario;
import backend.ListaUC;
import backend.Sistema;


public class Projeto_Interface {
    
    public static void main(String[] args) throws Exception {
        
        Sistema sistem = new Sistema();
        
        Consola consola = new Consola();

        ListaCursos cursos = sistem.getListaCursos();
        ListaUC ucs = sistem.getListaUC();
        ListaProfessores profs = sistem.getListaProfessores();
        ListaAluno alunos = sistem.getListaAluno();
        ListaSumario sums = sistem.getListasumarios();

        int option = 0;

        do {
            System.out.println("***********************");
            System.out.println("Bem-vindo ao DEP da Universidade do Minho");
            System.out.println("Introduza qual a sua função na Universidade: ");
            System.out.println("1-> Administrador");
            System.out.println("2-> Professor");
            System.out.println("3-> Regente da UC");
            System.out.println("4-> Diretor de Curso");
            System.out.println("5-> Carregar Dados");
            System.out.println("6-> Guardar Dados");
            System.out.println("0-> Sair do Programa");
            System.out.println("***********************");

            option = consola.lerInteiro();

            switch (option) {
                case 1:
                    Menu_Administrador.auth(cursos, ucs, profs, alunos, sistem, consola);
                    break;
                case 2:
                    Menu_Professor.authprof(profs, sums, ucs, consola, alunos);
                    break;
                case 3:
                    Menu_Regente.authregente(profs, ucs, alunos, consola, sums);
                    break;
                case 4:
                    Menu_Diretor.authdiretor(profs, cursos, alunos, consola);
                    break;
                case 5:
                    sistem.carregarDados();
                    break;
                case 6:
                    System.out.println("A guardar dados...");
                    sistem.guardarDados();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção Inválida. Tente novamente.");
            }
        } while (option != 0);
    }
}

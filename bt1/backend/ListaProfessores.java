package backend;

//import frontend.Menu_Administrador;
import frontend.Menu_Professor;
import backend.Professor;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ListaProfessores {
    private final ArrayList<Professor> listaProfessor;
    Scanner read = new Scanner(System.in);
    
    public ListaProfessores(){
        listaProfessor = new ArrayList<>();
    }
    
    public void inserir(Professor p){
        if (!listaProfessor.contains(p)) listaProfessor.add(p);
    }
    
    public int getNumProfessores(){
        return listaProfessor.size();
    }
   
    public Professor criarProfessor() {
        Professor professor1 = new Professor();
        System.out.println("Introduza o nome:");
        professor1.setNome(read.nextLine());
        System.out.println("Introduza o numero mecanografico:");
        professor1.setNumMecanografico(read.nextInt());
        read.nextLine();
        System.out.println("Introduza a data de inicio de funções:");
        professor1.setDataInicioFuncoes(read.nextLine());
        System.out.println("Introduza o username para o professor:");
        professor1.setUsername(read.nextLine());
        System.out.println("Introduza a password para o professor:");
        professor1.setPassword(read.nextLine());
        listaProfessor.add(professor1);
        System.out.println("Professor adicionado com sucesso!");
        return professor1;
    }
    
    public void listarProfessores() {
        if (listaProfessor.isEmpty()) {
            System.out.println("Nao ha professores registados no sistema");
        } else {
            for (Professor f: listaProfessor){
                System.out.println(f.getNome()+", "+ f.getNumMecanografico()
                        +", "+f.getDataInicioFuncoes()+"\n");
            }
        }
    }
    
    public void apagarProfessor() {
    System.out.println("Introduza o numero mecanografico do professor:");
    int nummecanograficoprof = read.nextInt();
    Iterator<Professor> iterator = listaProfessor.iterator();

    boolean encontrado = false;

    while (iterator.hasNext()) {
        Professor professor = iterator.next();
        if (professor.getNumMecanografico() == nummecanograficoprof) {
            iterator.remove();
            System.out.println("Professor removido com sucesso!");
            encontrado = true;
            break; 
        }
    }

    if (!encontrado) {
        System.out.println("Professor não encontrado na lista.");
    }
}

    public List<Professor> getListaProfessores() {
        return this.listaProfessor;
    }
    
    public void alterarInformacaoProfessor() {
        System.out.println("Introduza o numero mecanografico do professor:");
        int numMecanograficoProf = read.nextInt();
        read.nextLine();

        Professor professorParaAlterar = null;
        for (Professor professor : listaProfessor) {
            if (professor.getNumMecanografico() == numMecanograficoProf) {
                professorParaAlterar = professor;
                break;
            }
        }

        if (professorParaAlterar == null) {
            System.out.println("Professor não encontrado na lista.");
            return;
        }

        System.out.println("Escolha a informação para alterar:");
        System.out.println("1. Nome");
        System.out.println("2. Numero Mecanografico");
        System.out.println("3. Data de Inicio de Funções");
        System.out.println("4. Username");
        System.out.println("5. Password");

        int opcao = read.nextInt();
        read.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Introduza o novo nome:");
                professorParaAlterar.setNome(read.nextLine());
                break;
            case 2:
                System.out.println("Introduza o novo numero mecanografico:");
                professorParaAlterar.setNumMecanografico(read.nextInt());
                read.nextLine();
                break;
            case 3:
                System.out.println("Introduza a nova data de inicio de funções:");
                professorParaAlterar.setDataInicioFuncoes(read.nextLine());
                break;
            case 4:
                System.out.println("Introduza o novo username:");
                professorParaAlterar.setUsername(read.nextLine());
                break;
            case 5:
                System.out.println("Introduza a nova password:");
                professorParaAlterar.setPassword(read.nextLine());
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

        System.out.println("Informação do professor alterada com sucesso!");
}

}


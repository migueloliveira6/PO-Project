package backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListaUC {
    private final ArrayList<UnidadeCurricular> listaUC;
    Scanner read = new Scanner(System.in);
    
    public ListaUC(){
        listaUC = new ArrayList<>();
    }
    
    public void inserir(UnidadeCurricular uc){
        if (!listaUC.contains(uc)) listaUC.add(uc);
    }
    
    public int getNumUCS(){
        return listaUC.size();
    }
    
    public void listarUCs() {
        if (listaUC.isEmpty()) {
            System.out.println("Nao ha cursos registados no sistema");
        } else {
            for (UnidadeCurricular uc: listaUC){
                System.out.println(uc.getDesignacao());
            }
        }
    }
    
    public void registarUC() {
        UnidadeCurricular uc1 = new UnidadeCurricular();
        System.out.println("Introduza o nome:");
        uc1.setDesignacao(read.nextLine());
        listaUC.add(uc1);
        System.out.println("Unidade Curricular Registada com Sucesso!");
        
    }
    
    public void apagarUC() {
        System.out.println("Introduza o nome da Unidade Curricular:");
        String nomeuc = read.nextLine();
        Iterator<UnidadeCurricular> iterator = listaUC.iterator();

        boolean encontrado = false;

        while (iterator.hasNext()) {
            UnidadeCurricular uc = iterator.next();
            if (uc.getDesignacao().equals(nomeuc)) {
                iterator.remove();
                System.out.println("Unidade Curricular removida com sucesso!");
                encontrado = true;
                break; 
            }
        }
        if (!encontrado) {
            System.out.println("Unidade Curricular não encontrada na lista.");
        }

    }
    
    public void alterarInformacaoUC() {
        System.out.println("Introduza o nome da UC:");
        String nomedaUC = read.nextLine();

        UnidadeCurricular ucParaAlterar = null;
        for (UnidadeCurricular uc : listaUC) {
            if ((uc.getDesignacao()).equals(nomedaUC)) {
                ucParaAlterar = uc;
                break;
            }
        }

        if (ucParaAlterar == null) {
            System.out.println("Unidade Curricular não encontrado na lista.");
            return;
        }

        System.out.println("Introduza o novo nome:");
        ucParaAlterar.setDesignacao(read.nextLine());

        System.out.println("Informação da UC alterada com sucesso!");
    }
}


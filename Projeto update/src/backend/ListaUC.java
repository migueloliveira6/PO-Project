package backend;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class ListaUC implements Serializable{
    private Collection<UnidadeCurricular> listaUC;
    private transient Scanner read = new Scanner(System.in);
    
    public ListaUC(){
        listaUC = new ArrayList<>();
    }
    
    public void inserir(UnidadeCurricular uc){
        if (!listaUC.contains(uc)) listaUC.add(uc);
    }
    
    public int getNumUCS(){
        return listaUC.size();
    }
    
    public Collection<UnidadeCurricular> getListaUC() {
        return listaUC;
    }
    
    //Listar Unidades Curriculares
    
    public void listarUCs() {
        if (listaUC.isEmpty()) {
            System.err.println("Nao ha Unidades Curriculares registados no sistema");
        } else {
            for (UnidadeCurricular uc: listaUC){
                System.out.println(uc);
            }
        }
    }
    
    //Criar uma Unidade Curricular
    
    public void registarUC() {
        UnidadeCurricular uc1 = new UnidadeCurricular();
        System.out.println("Introduza o nome:");
        uc1.setDesignacao(read.nextLine());
        listaUC.add(uc1);
        System.out.println("Unidade Curricular Registada com Sucesso!");
        
    }
    
    //Remover uma Unidade Curricular da lista
    
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
            System.err.println("Unidade Curricular não encontrada na lista.");
        }

    }
    
    //Alterar informação de uma Unidade Curricular
    
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
            System.err.println("Unidade Curricular não encontrado na lista.");
            return;
        }

        System.out.println("Introduza o novo nome:");
        ucParaAlterar.setDesignacao(read.nextLine());

        System.out.println("Informação da UC alterada com sucesso!");
    }
    
    public UnidadeCurricular getUCByNome(String nome) {
        for (UnidadeCurricular uc : listaUC) {
            if (uc.getDesignacao().equals(nome)) {
                return uc;
            }
        }
        return null;  // Retorna null se a Unidade Curricular não for encontrada
    }
    
     public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(nomeFicheiro); 
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listaUC);
        }
    }
    
    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        
        try (FileInputStream file = new FileInputStream(nomeFicheiro); 
             ObjectInputStream oin = new ObjectInputStream(file)) {
            listaUC = (ArrayList<UnidadeCurricular>) oin.readObject();
        }
    }
}


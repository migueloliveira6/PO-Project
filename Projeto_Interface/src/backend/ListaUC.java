package backend;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ListaUC {
    private Collection<UnidadeCurricular> listaUC;
    
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
    //Remover uma Unidade Curricular da lista
    
    public void apagarUC(String nomeuc) {
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

    
    public UnidadeCurricular getUCByNome(String nome) {
        for (UnidadeCurricular uc : listaUC) {
            if (uc.getDesignacao().equals(nome)) {
                return uc;
            }
        }
        return null;  // Retorna null se a Unidade Curricular não for encontrada
    }
    
     public void guardarFicheiroObjetos() throws Exception {
        try (FileOutputStream fos = new FileOutputStream("ucs"); 
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listaUC);
        }
    }
    
    public void carregarFicheiroObjetos() throws Exception {
        
        try (FileInputStream file = new FileInputStream("ucs"); 
             ObjectInputStream oin = new ObjectInputStream(file)) {
            listaUC = (ArrayList<UnidadeCurricular>) oin.readObject();
        }
    }
}
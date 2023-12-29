package backend;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ListaCursos{
    
    private Collection<Curso> listaCursos;
    
    public ListaCursos(){
        listaCursos = new ArrayList<>();
    }
    
    public void inserir(Curso c){
        if (!listaCursos.contains(c)) listaCursos.add(c);
    }
    
    public int getNumCursos(){
        return listaCursos.size();
    }
    
    public Collection<Curso> getListaCurso() {
        return listaCursos;
    }
    
    public void listarCursos() {
        
        if (listaCursos.isEmpty()) {
            System.err.println("Nao ha cursos registados no sistema");
        } else {
            for (Curso c: listaCursos){
                System.out.println(c);
            }
        }
    }
    public void apagarCurso(String nomecurso) {

        Iterator<Curso> iterator = listaCursos.iterator();

        boolean encontrado = false;

        while (iterator.hasNext()) {
            Curso curso = iterator.next();
            if (curso.getDesignacao().equals(nomecurso)) {
                iterator.remove();
                System.out.println("Curso removido com sucesso!");
                encontrado = true;
                break; 
            }
        }
        if (!encontrado) {
            System.err.println("Curso não encontrado na lista.");
        }

    }
     
    public Curso getCursoByNome(String nome) {
        for (Curso curso : listaCursos) {
            if (curso.getDesignacao().equals(nome)) {
                return curso;
            }
        }
        return null;  // Retorna null se o curso não for encontrado
    }
    
    public void guardarFicheiroObjetos() throws Exception {
        try (FileOutputStream fos = new FileOutputStream("cursos"); 
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listaCursos);
        }
    }
    
    public void carregarFicheiroObjetos() throws Exception {
        try (FileInputStream file = new FileInputStream("cursos"); 
             ObjectInputStream oin = new ObjectInputStream(file)) {
            listaCursos = (ArrayList<Curso>) oin.readObject();
        }
    }
}

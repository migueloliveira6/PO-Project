package backend;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class ListaCursos implements Serializable{
    private Collection<Curso> listaCursos;
    private transient Scanner read = new Scanner(System.in);
    
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
    
    public void registarCurso() {
        Curso curso1 = new Curso();
        System.out.println("Introduza o nome:");
        curso1.setDesignacao(read.nextLine());
        listaCursos.add(curso1);
        System.out.println("Curso Registado com Sucesso!");
    }
    
    public void apagarCurso() {
        System.out.println("Introduza o nome do Curso:");
        String nomecurso = read.nextLine();
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
    
    public void alterarInformacaoCurso() {
        System.out.println("Introduza o nome do Curso:");
        String nomedoCurso = read.nextLine();

        Curso cursoparaAlterar = null;
        for (Curso curso : listaCursos) {
            if ((curso.getDesignacao()).equals(nomedoCurso)) {
                cursoparaAlterar = curso;
                break;
            }
        }

        if (cursoparaAlterar == null) {
            System.err.println("Curso não encontrado na lista.");
            return;
        }

        System.out.println("Introduza o novo nome:");
        cursoparaAlterar.setDesignacao(read.nextLine());

        System.out.println("Informação do Curso alterada com sucesso!");
    }
    
    public void alterarCursoinfoDiretor(Curso curso){
        System.out.println("Introduza o novo nome:");
        curso.setDesignacao(read.nextLine());

        System.out.println("Informação do Curso alterada com sucesso!");
    }
     
    public Curso getCursoByNome(String nome) {
        for (Curso curso : listaCursos) {
            if (curso.getDesignacao().equals(nome)) {
                return curso;
            }
        }
        return null;  // Retorna null se o curso não for encontrado
    }
    
    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(nomeFicheiro); 
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listaCursos);
        }
    }
    
    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        try (FileInputStream file = new FileInputStream(nomeFicheiro); 
             ObjectInputStream oin = new ObjectInputStream(file)) {
            listaCursos = (ArrayList<Curso>) oin.readObject();
        }
    }
}

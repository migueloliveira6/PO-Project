package backend;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ListaProfessores{
    
    private Collection<Professor> listaProfessor;
    
    public ListaProfessores(){
        listaProfessor = new ArrayList<>();
    }
    
    public ListaProfessores(Collection<Professor> professores) {
        listaProfessor = new ArrayList<>(professores);
    }
    
    public int getNumProfessores(){
        return listaProfessor.size();
    }
    
    public void inserir(Professor p){
        if (!listaProfessor.contains(p)){
            listaProfessor.add(p);
        }
    }
    
    public Collection<Professor> getLista() {
        return listaProfessor;
    }
 
    
    public void listarProfessores() {
        if (listaProfessor.isEmpty()) {
            System.err.println("Nao ha professores registados no sistema");
        } else {
            for (Professor f: listaProfessor){
                System.out.println(f);
            }
        }
    }
    
    public void apagarProfessor(int nummecanograficoprof) {

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
        System.err.println("Professor não encontrado na lista.");
    }
}
    
    public Map<Curso, Integer> getNumeroProfessoresPorCurso() {
        Map<Curso, Integer> numeroProfessoresPorCurso = new HashMap<>();

        for (Professor professor : listaProfessor) {
            Curso curso = professor.getCurso();

            if (curso != null) {
                numeroProfessoresPorCurso.merge(curso, 1, Integer::sum);
            }
        }

        return numeroProfessoresPorCurso;
    }
    
    public Professor getProfessorByNumMecanografico(int numMecanografico) {
        for (Professor professor : listaProfessor) {
            if (professor.getNumMecanografico() == numMecanografico) {
                return professor;
            }
        }
        return null;  // Retorna null se o professor não for encontrado
    }
    
    public void guardarFicheiroProf() throws Exception {
        try (FileOutputStream fos = new FileOutputStream("profs"); 
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listaProfessor);
        }
    }
    public void carregarFicheiroObjetos() throws Exception {
        try (FileInputStream file = new FileInputStream("profs"); 
             ObjectInputStream oin = new ObjectInputStream(file)) {
             listaProfessor = (ArrayList<Professor>) oin.readObject();
        }
    }
}
 
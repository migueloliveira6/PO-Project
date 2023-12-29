package backend;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ListaAluno{
    private Collection<Aluno> listaAluno;
    
    public ListaAluno(){
        listaAluno = new ArrayList<>();
    }
    
    public void inserir(Aluno a){
        if (!listaAluno.contains(a)) listaAluno.add(a);
    }
    
    public int getNumAlunos(){
        return listaAluno.size();
    }
    
    public void listarAlunos() {
        if (listaAluno.isEmpty()) {
            System.err.println("Nao ha alunos registados no sistema");
        } else {
            for (Aluno a: listaAluno){
                System.out.println(a);
            }
        }
    }
    
    public Collection<Aluno> getLista() {
        return listaAluno;
    }
    
    
    public void apagarAluno(int nummecanograficoaluno) {

        Iterator<Aluno> iterator = listaAluno.iterator();

        boolean encontrado = false;

        while (iterator.hasNext()) {
            Aluno aluno = iterator.next();
            if (aluno.getnumeromecanografico() == nummecanograficoaluno) {
                iterator.remove();
                System.out.println("Aluno removido com sucesso!");
                encontrado = true;
                break; 
            }
        }

        if (!encontrado) {
            System.out.println("Aluno não encontrado na lista.");
        }
    }
    
    public Aluno getAlunoByNumMecanico(int numMecan) {
        for (Aluno aluno : listaAluno) {
            if (aluno.getnumeromecanografico() == numMecan) {
                return aluno;
            }
        }
        return null;  
    }
    
    
    public void guardarFicheiroObjetos() throws Exception {
        try (FileOutputStream fos = new FileOutputStream("alunos"); 
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listaAluno);
        }
    }
     
    public void carregarFicheiroObjetos() throws Exception {
        try (FileInputStream file = new FileInputStream("alunos"); 
             ObjectInputStream oin = new ObjectInputStream(file)) {
            listaAluno = (ArrayList<Aluno>) oin.readObject();
        }
    }
    
    public Map<Curso, Integer> getNumeroAlunosPorCurso() {
        Map<Curso, Integer> numeroAlunosPorCurso = new HashMap<>();

        for (Aluno aluno : listaAluno) {
            Curso curso = aluno.getcurso();

            if (curso != null) {
                numeroAlunosPorCurso.merge(curso, 1, Integer::sum);
            }
        }

        return numeroAlunosPorCurso;
    }
}
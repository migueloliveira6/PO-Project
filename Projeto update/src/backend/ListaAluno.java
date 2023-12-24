package backend;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
//import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ListaAluno implements Serializable{
    private Collection<Aluno> listaAluno;
    private transient Scanner read = new Scanner(System.in);
    
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
    
    public void criarAluno(ListaCursos cursos, Sistema sistem) {
        Aluno a1 = new Aluno();
        System.out.println("Introduza o nome:");
        a1.setnome(read.nextLine());
        System.out.println("Introduza o numMecanografico:");
        a1.setnumeromecanografico(read.nextInt());
        read.nextLine();
        System.out.println("Introduza o curso do aluno:");
        if (!sistem.listaCursos.getListaCurso().isEmpty()){ 
            System.out.println("Lista de cursos:");
            cursos.listarCursos();
            System.out.println("Opção:");
            String designacaoCurso = read.nextLine();
            Curso curso = cursos.getCursoByNome(designacaoCurso);
            if (curso != null){
                a1.setcurso(curso);
            }else{
               System.out.println("Curso não encontrado. O aluno não terá nenhum curso associado.");
            }
        }else{
            System.out.println("A lista de cursos está vazia portanto não será possível associar curso ao aluno.");
        }
        listaAluno.add(a1);
        System.out.println("Aluno["+a1.getnome()+"] criado com Sucesso!");
    }
    
    public void apagarAluno() {
        System.out.println("Introduza o numero mecanografico do aluno:");
        int nummecanograficoaluno = read.nextInt();
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
    
    public void alterarInformacaoAluno(ListaCursos cursos) {
    System.out.println("Introduza o numero mecanografico do aluno:");
    int numMecanograficoAluno = read.nextInt();
    read.nextLine(); 
    
    Aluno alunoParaAlterar = null;
    for (Aluno aluno : listaAluno) {
        if (aluno.getnumeromecanografico() == numMecanograficoAluno) {
            alunoParaAlterar = aluno;
            break;
        }
    }

    if (alunoParaAlterar == null) {
        System.out.println("Aluno não encontrado na lista.");
        return;
    }

    System.out.println("Escolha a informação para alterar:");
    System.out.println("1. Nome");
    System.out.println("2. Numero Mecanografico");
    System.out.println("3. Curso");

    int opcao = read.nextInt();
    read.nextLine();

    switch (opcao) {
        case 1:
            System.out.println("Introduza o novo nome:");
            alunoParaAlterar.setnome(read.nextLine());
            break;
        case 2:
            System.out.println("Introduza o novo numero mecanografico:");
            alunoParaAlterar.setnumeromecanografico(read.nextInt());
            read.nextLine(); 
            break;
        case 3:
            System.out.println("Introduza o nome do curso:");
            System.out.println("Lista de Cursos disponíveis:");
            cursos.listarCursos();
            System.out.println("\nOpcão:");
            Curso curso = cursos.getCursoByNome(read.nextLine());
            if (curso != null) {
                alunoParaAlterar.setcurso(curso);
            } else {
                System.out.println("Curso não encontrado. O aluno não terá nenhum curso associado.");
            }
            break;
        default:
            System.out.println("Opção inválida.");
            break;
    }

    System.out.println("Informação do aluno alterada com sucesso!");
}
    
    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(nomeFicheiro); 
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listaAluno);
        }
    }
     
    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        try (FileInputStream file = new FileInputStream(nomeFicheiro); 
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
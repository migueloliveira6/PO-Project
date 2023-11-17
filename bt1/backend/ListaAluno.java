package backend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class ListaAluno {
    private final ArrayList<Aluno> listaAluno;
    Scanner read = new Scanner(System.in);
    
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
            System.out.println("Nao ha alunos registados no sistema");
        } else {
            for (Aluno a: listaAluno){
                System.out.println(a.getnome()+", "+ a.getnumeromecanografico()+"\n");
            }
        }
    }
    
    public void criarAluno() {
        Aluno a1 = new Aluno();
        System.out.println("Introduza o nome:");
        a1.setnome(read.nextLine());
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
    
    public void alterarInformacaoAluno() {
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
        default:
            System.out.println("Opção inválida.");
            break;
    }

    System.out.println("Informação do aluno alterada com sucesso!");
}

}
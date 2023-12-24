package backend;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ListaSumario implements Serializable{
    private Collection<SumarioAula> listaSum;
    
    private transient Scanner read = new Scanner(System.in);
    
    public ListaSumario(){
        listaSum = new ArrayList<>();
    }
    
    public void inserir(SumarioAula sum){
        if (!listaSum.contains(sum)) listaSum.add(sum);
    }
    
    public int getNumSum(){
        return listaSum.size();
    }
    
    public void criarSum(Professor prof, ListaUC listaUC) {

    System.out.println("Introduza o título do sumário:");
    String titulo = read.nextLine();

    System.out.println("Introduza o tipo de aula:");
    String tipo = read.nextLine();

    System.out.println("Introduza o sumário:");
    String sumario = read.nextLine();

    System.out.println("Indique qual a UC que pertence este sumário:");
    listaUC.listarUCs();
    System.out.println("\nOpcao:");
    String designacaoUC = read.nextLine();
    UnidadeCurricular uc = listaUC.getUCByNome(designacaoUC);

    if (uc != null) {
        SumarioAula sum = new SumarioAula(titulo,tipo,sumario,prof,uc);
        listaSum.add(sum);
    } else {
        System.err.println("UC não encontrada. O sumário não terá nenhuma UC associada.");
    }
    System.out.println("Sumario criado com sucesso!");
}
    
    public void consultarSumariosPorUCeTipoAula(UnidadeCurricular uc, String tipo) {
        
    System.out.println("Lista de Sumários para a UC '" + uc.getDesignacao() + "' e Tipo de Aula '" + tipo + "':");

    for (SumarioAula sumario : listaSum) {
        if (sumario.getUnidadeCurricular().equals(uc) && sumario.getTipo().equalsIgnoreCase(tipo)){
            System.out.println("Título: " + sumario.getTitulo());
            System.out.println("Tipo: " + sumario.getTipo());
            System.out.println("Sumário: " + sumario.getSumario());
            System.out.println("Professor: " + sumario.getProfessor().getNome());
            System.out.println("Unidade Curricular: " + sumario.getUnidadeCurricular().getDesignacao());
            System.out.println("------------------------------");
        }
    }
}
    
     public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(nomeFicheiro); 
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listaSum);
        }
    }
    
    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        try (FileInputStream file = new FileInputStream(nomeFicheiro); 
             ObjectInputStream oin = new ObjectInputStream(file)) {
            listaSum = (ArrayList<SumarioAula>) oin.readObject();
        }
    }
}

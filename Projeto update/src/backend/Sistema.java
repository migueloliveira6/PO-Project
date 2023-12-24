package backend;

import java.io.Serializable;
import java.util.Scanner;

public class Sistema implements Serializable{
    
    //private static final String CAMINHO_ARQUIVO = "C:\\Users\\Utilizador\\Documents\\teste";
    public final ListaProfessores listaProfessores;
    protected final ListaCursos listaCursos;
    protected final ListaUC listaUC;
    protected final ListaAluno listaaluno;
    protected final ListaSumario listasumarios;
    private transient Scanner read = new Scanner(System.in);
    
    public Sistema(){
        this.listaProfessores = new ListaProfessores();
        this.listaCursos = new ListaCursos();
        this.listaaluno = new ListaAluno();
        this.listaUC = new ListaUC();
        this.listasumarios = new ListaSumario();
    }

    public ListaProfessores getListaProfessores() {
        return listaProfessores;
    }

    public ListaCursos getListaCursos() {
        return listaCursos;
    }

    public ListaAluno getListaAluno(){
        return listaaluno;
    }
    
    public ListaUC getListaUC(){
        return listaUC;
    }

    public ListaSumario getListasumarios() {
        return listasumarios;
    }
    
    private void carregarDadosProf() throws Exception {
        System.out.println("Indique o nome do ficheiro dos prof");
        String nomeFicheiro = read.nextLine();
        getListaProfessores().carregarFicheiroProf(nomeFicheiro);
    }
    
    private void carregarDadosCurso() throws Exception {
        System.out.println("Indique o nome do ficheiro dos cursos");
        String nomeFicheiro = read.nextLine();
        getListaCursos().carregarFicheiroObjetos(nomeFicheiro);
    }
    
     private void carregarDadosAluno() throws Exception {
         System.out.println("Indique o nome do ficheiro dos alunos");
        String nomeFicheiro = read.nextLine();
         getListaAluno().carregarFicheiroObjetos(nomeFicheiro);
     }
     
      private void carregarDadosUCs() throws Exception {
          System.out.println("Indique o nome do ficheiro das ucs");
        String nomeFicheiro = read.nextLine();
          getListaUC().carregarFicheiroObjetos(nomeFicheiro);
      }
       private void carregarDadosSum() throws Exception {
           System.out.println("Indique o nome do ficheiro dos sums");
           String nomeFicheiro = read.nextLine();
           getListasumarios().carregarFicheiroObjetos(nomeFicheiro);
       }
    /*
    private void guardarDados() throws Exception {
        getListaProfessores().guardarFicheiroProf(CAMINHO_ARQUIVO);
        getListaCursos().guardarFicheiroObjetos(CAMINHO_ARQUIVO);
        getListaAluno().guardarFicheiroObjetos(CAMINHO_ARQUIVO);
        getListaUC().guardarFicheiroObjetos(CAMINHO_ARQUIVO);
        getListasumarios().guardarFicheiroObjetos(CAMINHO_ARQUIVO);
    }
    */
}
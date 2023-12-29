package backend;

public class Sistema{
    
    public final ListaProfessores listaProfessores;
    public final ListaCursos listaCursos;
    public final ListaUC listaUC;
    public final ListaAluno listaaluno;
    public final ListaSumario listasumarios;
    
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
    
    public void carregarDados() throws Exception{
        carregarDadosProf();
        carregarDadosCurso();
        carregarDadosAluno();
        carregarDadosUCs();
        carregarDadosSum();
        System.out.println("Dados carregados!");
    }
    
    private void carregarDadosProf() throws Exception {
    
        getListaProfessores().carregarFicheiroObjetos();
    }
    
    private void carregarDadosCurso() throws Exception {
    
        getListaCursos().carregarFicheiroObjetos();
    }
    
    private void carregarDadosAluno() throws Exception {
       
         getListaAluno().carregarFicheiroObjetos();
    }
     
    private void carregarDadosUCs() throws Exception {
        getListaUC().carregarFicheiroObjetos();
    }
    private void carregarDadosSum() throws Exception {
       
        getListasumarios().carregarFicheiroObjetos();
    }
    
    private void guardarDadosSum() throws Exception {
     
        getListasumarios().guardarFicheiroObjetos();
    }
    
    private void guardarDadosProf() throws Exception {

        getListaProfessores().guardarFicheiroProf();
    }
    
    private void guardarDadosCurso() throws Exception {
    
        getListaCursos().guardarFicheiroObjetos();
    }
    
    private void guardarDadosAluno() throws Exception {
        getListaAluno().guardarFicheiroObjetos();
    }
    
    private void guardarDadosUCs() throws Exception {
        getListaUC().guardarFicheiroObjetos();
    }
    
    public void guardarDados() throws Exception {
        guardarDadosProf();
        guardarDadosCurso();
        guardarDadosAluno();
        guardarDadosUCs();
        guardarDadosSum();
        System.out.println("Guardado!");
    }
}
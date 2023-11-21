package backend;

public class Sistema {
    private final ListaProfessores listaProfessores;
    private final ListaCursos listaCursos;
    private final ListaUC listaUC;
    private final ListaAluno listaaluno;

    public Sistema() {
        this.listaProfessores = new ListaProfessores();
        this.listaCursos = new ListaCursos();
        this.listaaluno = new ListaAluno();
        this.listaUC = new ListaUC();
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
}
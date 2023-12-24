package backend;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListaProfessores implements Serializable{
    
    private Collection<Professor> listaProfessor;
    
    private transient Scanner read = new Scanner(System.in);
    
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
    
   
    public Professor criarProfessor(ListaUC ucs,ListaCursos cursos, Sistema sistem) {
        Professor professor1 = new Professor();
        System.out.println("Introduza o nome:");
        professor1.setNome(read.nextLine());

        System.out.println("Introduza o numero mecanografico:");
        professor1.setNumMecanografico(read.nextInt());
        read.nextLine();

        System.out.println("Introduza a data de inicio de funções:");
        professor1.setDataInicioFuncoes(read.nextLine());
        
        System.out.println("UnidadeCurricular que este dá aulas:");
        System.out.println("Lista de UCs disponiveis:");
        if (!sistem.listaUC.getListaUC().isEmpty()){ 
            ucs.listarUCs();
            System.out.println("\nOpcão:");
            UnidadeCurricular uc = ucs.getUCByNome(read.nextLine());
                if (uc != null) {
                    professor1.setUnidadesCurriculares(Collections.singletonList(uc));
                    uc.adicionarProfessorEquipaDocente(professor1);
                } else {
                    System.err.println("UC não encontrada. O professor não terá nenhuma UC associada.");
                }
        }else{
            System.err.println("A lista de UCs está vazia portanto não será possível associar UCs ao professor.");
        }
        
        if (!sistem.listaCursos.getListaCurso().isEmpty()){ 
            System.out.println("Lista de cursos:");
            cursos.listarCursos();
            System.out.println("Opção:");
            String designacaoCurso = read.nextLine();
            Curso curso = cursos.getCursoByNome(designacaoCurso);
            if (curso != null){
                professor1.setCurso(curso);
            }else{
               System.err.println("Curso não encontrado. O professor não terá nenhum curso associado.");
            }
        }else{
            System.err.println("A lista de cursos está vazia portanto não será possível associar curso ao professor.");
        }
        System.out.println("Introduza a password para o professor:");
        professor1.setPassword(read.nextLine());

        listaProfessor.add(professor1);
        System.out.println("Professor adicionado com sucesso!");
        return professor1;
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
    
    public void apagarProfessor() {
    System.out.println("Introduza o numero mecanografico do professor:");
    int nummecanograficoprof = read.nextInt();
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
    
    public void alterarInformacaoProfessor(ListaUC ucs, ListaCursos cursos) {
    System.out.println("Introduza o numero mecanografico do professor:");
    int numMecanograficoProf = read.nextInt();
    read.nextLine();

    Professor professorParaAlterar = null;
    for (Professor professor : listaProfessor) {
        if (professor.getNumMecanografico() == numMecanograficoProf) {
            professorParaAlterar = professor;
            break;
        }
    }

    if (professorParaAlterar == null) {
        System.err.println("Professor não encontrado na lista.");
        return;
    }

    System.out.println("Escolha a informação para alterar:");
    System.out.println("1. Nome");
    System.out.println("2. Numero Mecanografico");
    System.out.println("3. Data de Inicio de Funções");
    System.out.println("4. Password");
    System.out.println("5. Unidade Curricular");
    System.out.println("6. Curso");

    int opcao = read.nextInt();
    read.nextLine();

    switch (opcao) {
        case 1:
            System.out.println("Introduza o novo nome:");
            professorParaAlterar.setNome(read.nextLine());
            break;
        case 2:
            System.out.println("Introduza o novo numero mecanografico:");
            professorParaAlterar.setNumMecanografico(read.nextInt());
            read.nextLine();
            break;
        case 3:
            System.out.println("Introduza a nova data de inicio de funções:");
            professorParaAlterar.setDataInicioFuncoes(read.nextLine());
            break;
        case 4:
            System.out.println("Introduza a nova password:");
            professorParaAlterar.setPassword(read.nextLine());
            break;
        case 5:
            System.out.println("UnidadeCurricular que este dá aulas:");
            System.out.println("Lista de UCs disponíveis:");
            ucs.listarUCs();
            System.out.println("\nOpcão:");
            UnidadeCurricular uc = ucs.getUCByNome(read.nextLine());
            if (uc != null) {
                professorParaAlterar.setUnidadesCurriculares(Collections.singletonList(uc));
                uc.adicionarProfessorEquipaDocente(professorParaAlterar);
            } else {
                System.err.println("UC não encontrada. O professor não terá nenhuma UC associada.");
            }
            break;
        case 6:
            System.out.println("Lista de cursos:");
            cursos.listarCursos();
            System.out.println("Opção:");
            String designacaoCurso = read.nextLine();
            Curso curso = cursos.getCursoByNome(designacaoCurso);
            if (curso != null){
                professorParaAlterar.setCurso(curso);
            }else{
               System.err.println("Curso não encontrado. O professor não terá nenhum curso associado.");
            }
        default:
            System.err.println("Opção inválida.");
            break;
    }

    System.out.println("Informação do professor alterada com sucesso!");
}

    public void consultarServicoDocente(Professor prof) {
        System.out.println("Consulta de Serviço Docente:");

            System.out.println("Nome do Professor: " + prof.getNome());
            System.out.println("Número Mecanográfico: " + prof.getNumMecanografico());
            System.out.println("Unidades Curriculares Regidas:");

            List<UnidadeCurricular> unidadesCurriculares = prof.getUnidadesCurriculares();
            if (unidadesCurriculares.isEmpty()) {
                System.err.println("Nenhuma unidade curricular atribuída.");
            } else {
                for (UnidadeCurricular uc : unidadesCurriculares) {
                    System.out.println("- " + uc.getDesignacao());
                }
            }

            System.out.println("------------------------------");
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
    
    public void guardarFicheiroProf(String nomeFicheiro) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(nomeFicheiro); 
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listaProfessor);
        }
    }
    /*
    public void carregarFicheiroProf(String nomeFicheiro) throws Exception {
        try (FileInputStream file = new FileInputStream(nomeFicheiro); 
            ObjectInputStream oin = new ObjectInputStream(file)) {
            listaProfessor = (ArrayList<Professor>) oin.readObject();
        }
    }
    */
    public void carregarFicheiroProf(String nomeFicheiro) throws Exception {
    try (FileInputStream file = new FileInputStream(nomeFicheiro);
         ObjectInputStream oin = new ObjectInputStream(file)) {

        Object object = oin.readObject();

        if (object instanceof ArrayList) {
            listaProfessor = (ArrayList<Professor>) object;
        } else {
            throw new IOException("Invalid data type in the file");
        }
    }
}
    
}
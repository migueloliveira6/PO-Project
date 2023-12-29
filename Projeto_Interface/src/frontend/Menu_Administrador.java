package frontend;
import java.util.Scanner;
import backend.Administrador;
import backend.Aluno;
import backend.Curso;
import backend.ListaAluno;
import backend.ListaCursos;
import backend.ListaProfessores;
import backend.ListaUC;
import backend.Professor;
import backend.Sistema;
import backend.UnidadeCurricular;
import java.util.Collections;

public class Menu_Administrador{
    
    
    public static void auth(ListaCursos cursos, ListaUC ucs, ListaProfessores profs, ListaAluno alunos, Sistema sistema, Consola consola){
                Scanner read = new Scanner(System.in);
                Administrador administrador = new Administrador();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("**************************************************************************");
                    System.out.println("*                      Digite o seu username e password!                 *");
                    System.out.println("**************************************************************************");
                    
                    System.out.print("Nome de usuário: ");
                    String username = read.nextLine();
                    
                    System.out.print("Senha: ");
                    String senha = read.nextLine();
                    
                    if (administrador.autenticar(username, senha) == true){
                        System.out.println("Autenticação bem-sucedida!");
                        Menu_Administrador.menu(cursos,ucs,profs,alunos,administrador, sistema, consola);
                    } else {
                        System.out.println("Credenciais inválidas. Tente novamente.");
                        return;
                    }
                } 
    
    public final static void clearConsole(){

        try{
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")){
                Runtime.getRuntime().exec("cls");

            }else{
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e){
        }
    }
    public static void menu(ListaCursos cursos, ListaUC ucs, ListaProfessores profs, ListaAluno alunos, Administrador admin, Sistema sistema, Consola consola) {
                int opcaoAdm = -1;
                
                while(opcaoAdm!=0){
                System.out.print("\033[H\033[2J");
                System.out.flush(); 
                System.out.println("**************************************************************************");
                System.out.println("*                      Bem vindo as opcoes do ADM!                       *");
                System.out.println("*   O que pretende fazer?                                                *");
                System.out.println("------------------------------PROFESSORES--------------------------------*");
                System.out.println("* 1 -> Criar professor                                                   *");
                System.out.println("* 2 -> Remover professor                                                 *");
                System.out.println("* 3 -> Alterar informação de professores                                 *");
		System.out.println("* 4 -> Listar professores                                                *");
		System.out.println("* 5 -> Atribuir regência de UC a professor                               *");
		System.out.println("* 6 -> Atribuir direção de curso a professor                             *");
                System.out.println("-------------------------------CURSOS------------------------------------*");
		System.out.println("* 7 -> Registar Curso                                                    *");
		System.out.println("* 8 -> Alterar informação de Curso                                       *");
		System.out.println("* 9 -> Listar cursos                                                     *");
		System.out.println("* 10 -> Remover Curso                                                    *");
                System.out.println("----------------------------UNIDADECURRICULAR----------------------------*");
		System.out.println("* 11 -> Registar UC                                                      *");
		System.out.println("* 12 -> Alterar informação de UC                                         *");
                System.out.println("* 13 -> Listar UCs                                                       *");
		System.out.println("* 14 -> Remover UC                                                       *");
                System.out.println("-------------------------------ALUNOS------------------------------------*");
		System.out.println("* 15 -> Criar aluno                                                      *");
                System.out.println("* 16 -> Listar alunos                                                    *");
		System.out.println("* 17 -> Remover aluno                                                    *");
                System.out.println("* 18 -> Alterar informação do Aluno                                      *");
                System.out.println("* 0 -> Voltar ao Menu Inicial                                            *");
                System.out.println("**************************************************************************");
                opcaoAdm = consola.lerInteiro();
                         
                switch(opcaoAdm){
                    
                    case 1: 
                        System.out.println("Criar professor: ");
                        Menu_Administrador.criarProfessor(ucs,cursos,profs, sistema, consola);
                        break;                
                    case 2:
                        System.out.println("Remover professor: ");
                        System.out.println("Introduza o numero mecanografico do professor:");
                        int nummecanograficoprof = consola.lerInteiro();
                        profs.apagarProfessor(nummecanograficoprof);
                        break;
                    case 3:
                        System.out.println("Alteracao de informacao de professores : ");
                        Menu_Administrador.alterarInformacaoProfessor(ucs, cursos, profs, consola);
                        break;
                    case 4: 
			System.out.println("Listar professores: ");
                        profs.listarProfessores();
                        break;                  
                    case 5: 
			System.out.println("Atribuir regência de UC a professor: ");
                        Menu_Administrador.atribuirRegenciaUC(profs, ucs, consola);
			break;
                    case 6: 
			System.out.println("Atribuir direção de curso a professor: ");
                        Menu_Administrador.atribuirDirecaoCurso(profs, cursos, consola);
			break;
                    case 7: 
			System.out.println("Registar Curso: ");
                        Menu_Administrador.registarCurso(cursos, consola);
                        break;					
                    case 8:
			System.out.println("Alterar informacao do curso: ");
                        Menu_Administrador.alterarInformacaoCurso(cursos, consola);
                        break;                  
                    case 9:
			System.out.println("Listar Cursos: ");
                        cursos.listarCursos();
                        break;					                       	
                    case 10:
                        System.out.println("Remover Curso: ");
                        System.out.println("Introduza o nome do Curso:");
                        String nomecurso = consola.lerString();
                        cursos.apagarCurso(nomecurso);
                        break;	
                    case 11:
                        System.out.println("Registar UC: ");
                        Menu_Administrador.registarUC(ucs, consola);
			break;
                    case 12:
			System.out.println("Alterar informacao da UC: ");
                        Menu_Administrador.alterarInformacaoUC(ucs, consola);
                        break;	
                    case 13:
                        System.out.println("Listar UCs: ");
                        ucs.listarUCs();
                        break;					
                    case 14: 
			System.out.println("Remover UC: ");
                        System.out.println("Introduza o nome da Unidade Curricular:");
                        String nomeuc = consola.lerString();
                        ucs.apagarUC(nomeuc);
                        break;					
                    case 15:
			System.out.println("Criar aluno: ");
                        Menu_Administrador.criarAluno(alunos, cursos, sistema, consola);
			break;
                    case 16:
			System.out.println("Listar alunos: ");
                        alunos.listarAlunos();
                        break;
                    case 17:
                        System.out.println("Remover aluno: ");
                        System.out.println("Introduza o numero mecanografico do aluno:");
                        int nummecanograficoaluno = consola.lerInteiro();
                        alunos.apagarAluno(nummecanograficoaluno);
                        break;
                    case 18:
                        System.out.println("Alterar informacao do Aluno: ");
                        Menu_Administrador.alterarInformacaoAluno(alunos, cursos, consola);
                        break;
                    case 0:  
                        System.out.println("A voltar para o menu inicial...");
                        break;
                    default: 
                        System.out.println("ERRO NA INTRODUCAO DA OPCAO");
                        break;
                    }
                }
    }
    
                              // PROFESSORES //
    
    
    public static Professor criarProfessor(ListaUC ucs, ListaCursos cursos, ListaProfessores profs, Sistema sistem, Consola consola) {

        Professor professor1 = new Professor();

        System.out.println("Introduza o nome:");
        professor1.setNome(consola.lerString());

        boolean numeroUnico = false;
        do {
            System.out.println("Introduza o numero mecanografico:");
            int numMecanografico = consola.lerInteiro();

            // Verificar se o número mecanográfico já existe
            if (profs.getProfessorByNumMecanografico(numMecanografico) == null) {
                professor1.setNumMecanografico(numMecanografico);
                numeroUnico = true;
            } else {
                System.err.println("O número mecanográfico já existe. Por favor, introduza um número único.");
            }
        } while (!numeroUnico);

        System.out.println("Introduza a data de inicio de funções:");
        professor1.setDataInicioFuncoes(consola.lerData());

        System.out.println("UnidadeCurricular que este dá aulas:");
        System.out.println("Lista de UCs disponiveis:");
        if (!sistem.listaUC.getListaUC().isEmpty()) {
            ucs.listarUCs();
            System.out.println("\nOpcão:");
            UnidadeCurricular uc = ucs.getUCByNome(consola.lerString());
            if (uc != null) {
                professor1.adicionarUCaoProf(uc);
                uc.adicionarProfessorEquipaDocente(professor1);
            } else {
                System.err.println("UC não encontrada. O professor não terá nenhuma UC associada.");
            }
        } else {
            System.err.println("A lista de UCs está vazia portanto não será possível associar UCs ao professor.");
        }

        if (!sistem.listaCursos.getListaCurso().isEmpty()) {
            System.out.println("Lista de cursos:");
            cursos.listarCursos();
            System.out.println("Opção:");
            String designacaoCurso = consola.lerString();
            Curso curso = cursos.getCursoByNome(designacaoCurso);
            if (curso != null) {
                professor1.setCurso(curso);
                curso.adicionarProfaoCurso(professor1);
            } else {
                System.err.println("Curso não encontrado. O professor não terá nenhum curso associado.");
            }
        } else {
            System.err.println("A lista de cursos está vazia portanto não será possível associar curso ao professor.");
        }

        // Introduzir password
        System.out.println("Introduza a password para o professor:");
        professor1.setPassword(consola.lerString());

        // Inserir o professor na lista de professores
        profs.inserir(professor1);
        System.out.println("Professor adicionado com sucesso!");

        return professor1;
}
    
    private static void alterarInformacaoProfessor(ListaUC ucs, ListaCursos cursos, ListaProfessores profs, Consola consola) {
        
        System.out.println("Introduza o numero mecanografico do professor:");
        int numMecanograficoProf = consola.lerInteiro();

        Professor professorParaAlterar = null;
        for (Professor professor : profs.getLista()) {
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

        int opcao = consola.lerInteiro();

        switch (opcao) {
            case 1:
                System.out.println("Introduza o novo nome:");
                professorParaAlterar.setNome(consola.lerString());
                break;
            case 2:
                boolean numeroUnico = false;
                do {
                    System.out.println("Introduza o novo numero mecanografico:");
                    int numMecanografico = consola.lerInteiro();
                    consola.lerString();

                    // Verificar se o número mecanográfico já existe
                    if (profs.getProfessorByNumMecanografico(numMecanografico) == null) {
                        professorParaAlterar.setNumMecanografico(numMecanografico);
                        numeroUnico = true;
                    } else {
                        System.err.println("O número mecanográfico já existe. Por favor, introduza um número único.");
                    }
                } while (!numeroUnico);
                break;
            case 3:
                System.out.println("Introduza a nova data de inicio de funções:");
                professorParaAlterar.setDataInicioFuncoes(consola.lerData());
                break;
            case 4:
                System.out.println("Introduza a nova password:");
                professorParaAlterar.setPassword(consola.lerString());
                break;
            case 5:
                System.out.println("UnidadeCurricular que este dá aulas:");
                System.out.println("Lista de UCs disponíveis:");
                ucs.listarUCs();
                System.out.println("\nOpcão:");
                UnidadeCurricular uc = ucs.getUCByNome(consola.lerString());
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
                String designacaoCurso = consola.lerString();
                Curso curso = cursos.getCursoByNome(designacaoCurso);
                if (curso != null){
                    curso.removerProfDoCurso(professorParaAlterar);
                    professorParaAlterar.setCurso(curso);
                    curso.adicionarProfaoCurso(professorParaAlterar);
                }else{
                   System.err.println("Curso não encontrado. O professor não terá nenhum curso associado.");
                }
                break;
            default:
                System.err.println("Opção inválida.");
                break;
        }

        System.out.println("Informação do professor alterada com sucesso!");
    }
    
    
                        // CURSOS //
    
    
    public static void registarCurso(ListaCursos cursos, Consola consola) {
        
        Curso curso1 = new Curso();

        boolean nomeUnico = false;
        do {
            System.out.println("Introduza o nome:");
            String nomeCurso = consola.lerString();

            if (cursos.getCursoByNome(nomeCurso) == null) {
                curso1.setDesignacao(nomeCurso);
                nomeUnico = true;
            } else {
                System.err.println("O nome do curso já existe. Por favor, introduza um nome único.");
            }
        } while (!nomeUnico);

        // Inserir o curso na lista de cursos
        cursos.inserir(curso1);
        System.out.println("Curso Registado com Sucesso!");
    }
    
    public static void alterarInformacaoCurso(ListaCursos cursos, Consola consola) {
        
        System.out.println("Introduza o nome do Curso:");
        String nomedoCurso = consola.lerString();

        Curso cursoparaAlterar = null;
        for (Curso curso : cursos.getListaCurso()) {
            if ((curso.getDesignacao()).equals(nomedoCurso)) {
                cursoparaAlterar = curso;
                break;
            }
        }

        if (cursoparaAlterar == null) {
            System.err.println("Curso não encontrado na lista.");
            return;
        }

        boolean nomeUnico = false;
        do {
            System.out.println("Introduza o nome:");
            String nomeCurso = consola.lerString();

            if (cursos.getCursoByNome(nomeCurso) == null) {
                cursoparaAlterar.setDesignacao(nomeCurso);
                nomeUnico = true;
            } else {
                System.err.println("O nome do curso já existe. Por favor, introduza um nome único.");
            }
        } while (!nomeUnico);

        System.out.println("Informação do Curso alterada com sucesso!");
    }
    
    
                  // UNIDADESCURRICULAR //
    
    
    //Criar uma Unidade Curricular
    
    public static void registarUC(ListaUC ucs, Consola consola) {
        
        UnidadeCurricular uc1 = new UnidadeCurricular();
        boolean nomeUnico = false;
        do {
            System.out.println("Introduza o nome:");
            String nomeUC = consola.lerString();

            if (ucs.getUCByNome(nomeUC) == null) {
                uc1.setDesignacao(nomeUC);
                nomeUnico = true;
            } else {
                System.err.println("O nome da Unidade Curricular já existe. Por favor, introduza um nome único.");
            }
        } while (!nomeUnico);

        ucs.inserir(uc1);
        System.out.println("Unidade Curricular Registada com Sucesso!");
        
    }
    
    //Alterar informação de uma Unidade Curricular
    
    public static void alterarInformacaoUC(ListaUC ucs, Consola consola) {

        System.out.println("Introduza o nome da UC:");
        String nomedaUC = consola.lerString();

        UnidadeCurricular ucParaAlterar = null;
        for (UnidadeCurricular uc : ucs.getListaUC()) {
            if ((uc.getDesignacao()).equals(nomedaUC)) {
                ucParaAlterar = uc;
                break;
            }
        }

        if (ucParaAlterar == null) {
            System.err.println("Unidade Curricular não encontrado na lista.");
            return;
        }

        boolean nomeUnico = false;
        do {
            System.out.println("Introduza o nome:");
            String nomeUC = consola.lerString();

            if (ucs.getUCByNome(nomeUC) == null) {
                ucParaAlterar.setDesignacao(nomeUC);
                nomeUnico = true;
            } else {
                System.err.println("O nome da Unidade Curricular já existe. Por favor, introduza um nome único.");
            }
        } while (!nomeUnico);

        System.out.println("Informação da UC alterada com sucesso!");
    }
    
    
                    // ALUNOS 
    
    public static void criarAluno(ListaAluno alunos, ListaCursos cursos, Sistema sistem, Consola consola) {
        
        Aluno a1 = new Aluno();
        System.out.println("Introduza o nome:");
        a1.setnome(consola.lerString());
        boolean numeroUnico = false;
                do {
                    System.out.println("Introduza o numero mecanografico:");
                    int numMecanografico = consola.lerInteiro();

                    // Verificar se o número mecanográfico já existe
                    if (alunos.getAlunoByNumMecanico(numMecanografico) == null) {
                        a1.setnumeromecanografico(numMecanografico);
                        numeroUnico = true;
                    } else {
                        System.err.println("O número mecanográfico já existe. Por favor, introduza um número único.");
                    }
                } while (!numeroUnico);
        alunos.inserir(a1);
        System.out.println("Aluno["+a1.getnome()+"] criado com Sucesso!");
    }
    
    
    public static void alterarInformacaoAluno(ListaAluno alunos, ListaCursos cursos, Consola consola) {
        
        System.out.println("Introduza o numero mecanografico do aluno:");
        int numMecanograficoAluno = consola.lerInteiro();

        Aluno alunoParaAlterar = null;
        for (Aluno aluno : alunos.getLista()) {
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

        int opcao = consola.lerInteiro();

        switch (opcao) {
            case 1:
                System.out.println("Introduza o novo nome:");
                alunoParaAlterar.setnome(consola.lerString());
                break;
            case 2:
                boolean numeroUnico = false;
                do {
                    System.out.println("Introduza o numero mecanografico:");
                    int numMecanografico = consola.lerInteiro();

                    // Verificar se o número mecanográfico já existe
                    if (alunos.getAlunoByNumMecanico(numMecanografico) == null) {
                        alunoParaAlterar.setnumeromecanografico(numMecanografico);
                        numeroUnico = true;
                    } else {
                        System.err.println("O número mecanográfico já existe. Por favor, introduza um número único.");
                    }
                } while (!numeroUnico);
                break;
            case 3:
                System.out.println("Introduza o nome do curso:");
                System.out.println("Lista de Cursos disponíveis:");
                cursos.listarCursos();
                System.out.println("\nOpcão:");
                Curso curso = cursos.getCursoByNome(consola.lerString());
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
    
    public static void atribuirDirecaoCurso(ListaProfessores profs, ListaCursos cursos, Consola consola) {

        System.out.println("Professores disponíveis:");
        profs.listarProfessores();

        System.out.println("Cursos disponíveis:");
        cursos.listarCursos(); 

        System.out.print("Digite o número mecanográfico do professor que será diretor de curso: ");
        int numMecanografico = consola.lerInteiro(); 

        System.out.print("Digite o nome do curso para o qual deseja atribuir a direção: ");
        String nomeCurso = consola.lerString();

        Professor professor = profs.getProfessorByNumMecanografico(numMecanografico);
        Curso curso = cursos.getCursoByNome(nomeCurso);

        if (professor != null && curso != null) {
            curso.setDiretorCurso(professor);
            professor.setDiretorDeCurso(true);
            professor.setCurso(curso);
            System.out.println("Direção do curso atribuída com sucesso!");
        } else {
            System.out.println("Erro: Professor ou curso não encontrado.");
        }
}

    public static void atribuirRegenciaUC(ListaProfessores profs, ListaUC ucs, Consola consola) {

        System.out.println("Professores disponíveis:");
        profs.listarProfessores();  

        System.out.println("UCs disponíveis:");
        ucs.listarUCs();

        System.out.print("Digite o número mecanográfico do professor que será regente: ");
        int numMecanografico = consola.lerInteiro();

        System.out.print("Digite o nome da unidade curricular para o qual deseja atribuir a regência: ");
        String nomeUC = consola.lerString();

        Professor professor = profs.getProfessorByNumMecanografico(numMecanografico);
        UnidadeCurricular uc = ucs.getUCByNome(nomeUC);

        if (professor != null && uc != null) {
            uc.atribuirRegencia(professor);
            professor.setRegente(true);
            if (!professor.getUnidadesCurriculares().contains(uc)){
                professor.adicionarUCaoProf(uc);
            }
        } else {
            System.out.println("Erro: Professor ou curso não encontrado.");
        }
    }
}
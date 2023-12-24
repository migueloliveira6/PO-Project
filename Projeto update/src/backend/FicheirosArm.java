package backend;

import java.io.*;

public class FicheirosArm {
  
    public static ListaProfessores carregarProfessores(String caminho) {
        ListaProfessores listaProfessores = new ListaProfessores();
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(caminho))) {
            Object obj;
            while ((obj = is.readObject()) != null) {
                if (obj instanceof ListaProfessores) {
                    listaProfessores = (ListaProfessores) obj;
                }
            }
        } catch (EOFException e) {
            // Fim do arquivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaProfessores;
    }

    // Adicione funções semelhantes para outros tipos de objetos (ListaCursos, ListaUC, ListaSumario, ListaAluno)

    // Exemplo para ListaCursos
    public static ListaCursos carregarCursos(String caminho) {
        ListaCursos listaCursos = new ListaCursos();
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(caminho))) {
            Object obj;
            while ((obj = is.readObject()) != null) {
                if (obj instanceof ListaCursos) {
                    listaCursos = (ListaCursos) obj;
                }
            }
        } catch (EOFException e) {
            // Fim do arquivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaCursos;
    }

    // Exemplo para ListaUC
    public static ListaUC carregarUC(String caminho) {
        ListaUC listaUC = new ListaUC();
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(caminho))) {
            Object obj;
            while ((obj = is.readObject()) != null) {
                if (obj instanceof ListaUC) {
                    listaUC = (ListaUC) obj;
                }
            }
        } catch (EOFException e) {
            // Fim do arquivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaUC;
    }

    // Exemplo para ListaSumario
    public static ListaSumario carregarSumarios(String caminho) {
        ListaSumario listaSumario = new ListaSumario();
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(caminho))) {
            Object obj;
            while ((obj = is.readObject()) != null) {
                if (obj instanceof ListaSumario) {
                    listaSumario = (ListaSumario) obj;
                }
            }
        } catch (EOFException e) {
            // Fim do arquivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaSumario;
    }

    // Exemplo para ListaAluno
    public static ListaAluno carregarAlunos(String caminho) {
        ListaAluno listaAluno = new ListaAluno();
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(caminho))) {
            Object obj;
            while ((obj = is.readObject()) != null) {
                if (obj instanceof ListaAluno) {
                    listaAluno = (ListaAluno) obj;
                }
            }
        } catch (EOFException e) {
            // Fim do arquivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaAluno;
    }
}

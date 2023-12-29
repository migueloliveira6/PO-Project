
package frontend;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Consola {
    
    private final Scanner scanner = new Scanner(System.in);
    
    public void escreverErro(String mensagem) {
        System.err.println(mensagem);
    }
    
    public String lerString() {
        return scanner.nextLine();
    }
    
    public int lerInteiro() {
        Integer numero = null;
        String texto;
        
        do {
            texto = scanner.nextLine();

            try {
                numero = Integer.valueOf(texto);
            } catch (NumberFormatException e) {
                escreverErro(texto + " não é um número inteiro válido.");
            }

        } while (numero == null);

        return numero;
    }
    
    public LocalDate lerData() {
        LocalDate data = null;
        String texto;

        do {
            texto = scanner.nextLine();

            try {
                data = LocalDate.parse(texto, DateTimeFormatter.ofPattern("d/M/yyyy"));
            } catch (DateTimeParseException e) {
                escreverErro(texto + " não é um data no formato dd/mm/aaaa.");
            }

        } while (data == null);

        return data;
    }
}


import java.util.Scanner;

public class Palindroma {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String fraseFin = "";
        System.out.println("Escribe una frase");
        String frase = sc.nextLine();
        char[] alReves = frase.toCharArray();
        for (int i = alReves.length - 1; i >= 0; i--) {
            fraseFin += alReves[i];
        }
        
        fraseFin = fraseFin.replace(" ", "");
        frase = frase.replace(" ", "");

        if (frase.equalsIgnoreCase(fraseFin)) {
            System.out.println(frase + " y " + fraseFin + " Es palindroma");
        } else {
            System.out.println(frase + " y " + fraseFin + " no son palindromas");
        }
    }
}

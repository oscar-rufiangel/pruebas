
import java.util.Scanner;

public class AnalizaFrase {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String maxPalabra = "";
        String minPalabra = "";
        System.out.println("Escribe una frase:");
        String frase = sc.nextLine().toLowerCase();
        String[] arrayFrase = frase.split(" ");
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arrayFrase.length; i++) {
            if (arrayFrase[i].length() > max) {
                max = arrayFrase[i].length();
                maxPalabra = arrayFrase[i];
            } else if (arrayFrase[i].length() < min) {
                min = arrayFrase[i].length();
                minPalabra = arrayFrase[i];
            }
        }
        System.out.println("La frase tiene " + arrayFrase.length + ""
                + "\nLa palabra mas larga es " + maxPalabra + " y mide " + max + " caracteres "
                + "\nLa mas corta es " + minPalabra + " tiene " + min + " caracteres ");
    }
}


import java.util.Arrays;
import java.util.Scanner;


public class Ordenar {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        String fraseFinal="";
        System.out.println("Escribe una frase para ordenar las palabras de alfabeticamente.");
        String[] frase=sc.nextLine().split(" ");
        Arrays.sort(frase);
        for (String palabra:frase) {
            fraseFinal+=palabra+" ";
        }
        System.out.println(fraseFinal);
    }
}

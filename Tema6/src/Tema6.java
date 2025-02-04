
import java.util.Scanner;


public class Tema6 {
    static Scanner sc =new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Escribe una frase");
        String frase=sc.nextLine();
        int principio= frase.indexOf(' ');
        int fin= frase.lastIndexOf(' ');
        System.out.println("Primera palabra "+frase.substring(0, principio));
        System.out.println("Ultima palabra "+frase.substring(fin+1));
    }
    
}


import java.util.Scanner;


public class BorrarComentarios {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Escribe una palabra para dividirla en las letras que quieras");
        String palabra=sc.nextLine();
        System.out.println("ahora escribe en cuantas letras quieres dividirla");
        int dividido=sc.nextInt();
        int cont=dividido;
        for (int i = 0; i < palabra.length(); i+=dividido) {
            System.out.println(palabra.substring(i,cont));
            cont+=dividido;
            if (cont>=palabra.length()) {
                cont=palabra.length();
            }
            
        }
            
        
    }
}


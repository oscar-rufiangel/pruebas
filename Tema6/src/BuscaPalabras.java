
import java.util.Scanner;



public class BuscaPalabras {
 static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int cont=0;
        System.out.println("Escribe una frase:");
        String frase = sc.nextLine().toLowerCase();
        System.out.println("Ahora escribe la palabra que quieres contar");
        String palabra=sc.nextLine().toLowerCase();
        
        String[] palabras=frase.split(" ");
        for (String palabraArray : palabras) {
            if(palabra.equals(palabraArray)){
                cont++;
            }
        }
        System.out.println("La palabra "+palabra+" aparece "+cont+" veces.");
    }
    
}

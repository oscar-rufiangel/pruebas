
import java.util.Scanner;


public class CaracEnString {
    static Scanner sc =new Scanner(System.in);
    public static void main(String[] args) {
        int cont=0;
        System.out.println("Introduce la letra a buscar");
     char letra = sc.nextLine().charAt(0);
        System.out.println("Introduce una palabra");
        String palabra=sc.nextLine();
        for (char PalLetra : palabra.toCharArray()) {
            if(Character.toLowerCase(letra)==Character.toLowerCase(PalLetra)){
                cont++;
            }
        }
        System.out.println("El caracter "+letra+" Aparece "+cont);
    }
}

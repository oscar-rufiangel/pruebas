
import java.util.Scanner;


public class MostrarFrase {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Escribe una oracion: ");
        String oracion=sc.nextLine();
        System.out.println("Ahora escribe desde donde quieres que la muestre ");
        int index=sc.nextInt();
        System.out.println(oracion.substring(index));
        System.out.println("Ahora escribe donde quieres que acabe ");
        int indexFin=sc.nextInt();
        System.out.println(oracion.substring(index,indexFin));
    }
}

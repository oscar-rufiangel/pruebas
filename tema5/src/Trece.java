
import java.util.Scanner;

public class Trece {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Escribe el valor clave que quieres buscar en la lista: ");
        int clave = sc.nextInt();
        int t[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("El valor clave esta en: " + buscar(t, clave));
    }

    static int buscar(int t[], int clave) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] == clave) {
                return i;
            }
        }
        return -1;
    }

}

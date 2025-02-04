
import java.util.Arrays;
import java.util.Scanner;

public class veinte {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(Arrays.toString(introducirProgramadores()));

    }

    static int[] introducirProgramadores() {
        int puntuacion;
        int[] temp = new int[0];
        System.out.println("Vamos a añadir un la puntuación de los programadores.");
        for (int i = 0; i < 5; i++) {
            System.out.println("Introduce un una puntuacion");
            puntuacion = sc.nextInt();
            if (puntuacion == -1) {
                do {
                    System.out.println("Introduce la puntuacion del programador de exibicion. "
                            + "\nEscribe menos uno otra vez para dejar de introducir programadores de exibicion.");
                    puntuacion = sc.nextInt();
                    if (puntuacion != -1) {
                        temp = insertarOrdenado(temp, puntuacion);
                    }

                } while (puntuacion != -1);
                System.out.println("Introduce la puntuacion del programador de exibicion. "
                        + "\nEscribe menos uno otra vez para dejar de introducir programadores de exibicion.");
                puntuacion = sc.nextInt();
            }
                temp = insertarOrdenado(temp, puntuacion);

        }
        return temp;
    }

    static int[] insertarOrdenado(int[] t, int nuevo) {
        int[] temp = new int[t.length + 1];
        int indice = Arrays.binarySearch(t, nuevo) >= 0 ? Arrays.binarySearch(t, nuevo) + 1 : -(Arrays.binarySearch(t, nuevo)) - 1;
        for (int i = 0; i < indice; i++) {
            temp[i] = t[i];
        }
        temp[indice] = nuevo;
        for (int i = indice; i < t.length; i++) {
            temp[i + 1] = t[i];
        }
        return temp;
    }

}

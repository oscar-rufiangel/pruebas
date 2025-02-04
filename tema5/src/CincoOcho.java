
import java.util.Arrays;
import java.util.Scanner;

public class CincoOcho {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] pares = new int[0];
        int[] impares = new int[0];
        int[] t = añadirArrays();
        Arrays.sort(pares);
        Arrays.sort(impares);
        System.out.println("Los pares son " + Arrays.toString(pares(t, pares)));
        System.out.println("Los impares son " + Arrays.toString(impares(t, impares)));
    }
//busca pares
    static int[] pares(int[] t, int[] par) {

        for (int i : t) {
            if (i % 2 == 0) {
                par = Arrays.copyOf(par, par.length + 1);
                par[par.length - 1] = i;
            }

        }
        return par;
    }
//Busca impares
    static int[] impares(int[] t, int[] impar) {

        for (int i : t) {
            if (i % 2 != 0) {
                impar = Arrays.copyOf(impar, impar.length + 1);
                impar[impar.length - 1] = i;
            }

        }
        return impar;
    }
//Añade numeros a un array infinito.
    static int[] añadirArrays() {
        int[] temp = new int[0];
        int num;
        do {
            System.out.println("Escribe un numero entero, para añadirlo a la lista. Pulse (-1) para salir.");
            num = sc.nextInt();
            if (buscar(temp, num) == -1 && num != -1) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = num;
            }

        } while (num != -1);
        return temp;
    }
//funcion para buscar si existe el numero en el array para que no esten repetidos
    static int buscar(int[] t, int clave) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] == clave) {
                return i;
            }
        }
        return -1;
    }
}

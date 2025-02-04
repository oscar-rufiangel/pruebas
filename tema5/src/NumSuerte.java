
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class NumSuerte {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int[] t = arrayFavoritos();
        System.out.println(Arrays.toString(t));
        while (t.length != 1) {
            t = media(t);
            System.out.println(Arrays.toString(t));
        }
    }

    static int[] arrayFavoritos() {
        System.out.println("escribe cuantos numeros favoritos vas a escribir");
        int num;
        do {
            System.out.println("Escribe un numero valor positivo");
            num = sc.nextInt();
        } while (num < 0);
        int[] t = new int[0];
        t = pedirNum(t, num);

        return t;
    }

    static int[] pedirNum(int t[], int aLength) {

        for (int i = 0; i < aLength; i++) {
            System.out.println("Escribe tu numero favorito");
            int num = sc.nextInt();
            t = insertarOrdenado(t, num);
        }
        return t;
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

    static int[] media(int[] t) {
        int num = random.nextInt(0, t.length);
        int num2 = random.nextInt(0, t.length);
        while (num == num2) {
            num2 = random.nextInt(0, t.length);
        }
        //Hacemos la media
        int media = t[num] + t[num2] / 2;
        //Borramos los numeros
        t=borrarTablaOrd(t, num);
        t=borrarTablaOrd(t, num2);
        
        //lo insertamos en el array
        t=insertarOrdenado(t, media);
        return t;
    }

    static int[] borrarTablaOrd(int t[], int indice) {
        if (indice > t.length - 1) {
            return new int[0];
        }
        int[] resultado = new int[t.length - 1];
        System.arraycopy(t, 0, resultado, 0, indice);
        if (indice != t.length - 1) {
            System.arraycopy(t, indice + 1, resultado, indice, (t.length - indice - 1));
        }
        return resultado;
    }

}

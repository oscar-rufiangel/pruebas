
import java.util.Arrays;
import java.util.Scanner;

public class inserccionOrdenada {

    public static void main(String[] args) {
        int[] t = new int[10];
        for (int i = 0; i < t.length; i++) {
            t[i] = (int) (Math.random() * 1000 + 1);
            System.out.println(t[i]);
        }
        int nuevo = pedirNumeroArrays(t);
        Arrays.sort(t);
        int [] resultado = insertarOrdenado(t,nuevo);
        System.out.println(Arrays.toString(resultado));
    }

    static int[] insertarOrdenado(int[] t,int nuevo) {
        int[] temp = new int[t.length+1];
        int indice = Arrays.binarySearch(t, nuevo) >= 0 ? Arrays.binarySearch(t, nuevo) + 1 : -(Arrays.binarySearch(t, nuevo)) - 1;
        for (int i = 0; i < indice; i++) {
            temp[i]=t[i];
        }
        temp[indice]=nuevo;
        for (int i = indice; i <t.length; i++) {
            temp[i+1]=t[i];
        }
        return temp;
    }

    static int pedirNumeroArrays(int[] t) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Estribe un numero para");
        int num = sc.nextInt();
        return num;
    }
}

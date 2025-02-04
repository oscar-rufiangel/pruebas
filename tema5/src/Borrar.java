
import java.util.Arrays;

public class Borrar {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 90, 80, 70, 60, 50, 40};
        int valor = 40;
        System.out.println(Arrays.toString(sinMayores(t, valor)));
    }

    static int[] sinMayores(int[] t, int valor) {
        int[] temp = Arrays.copyOf(t, t.length);
        int cont = 0;
        while (cont < temp.length) {
            if (temp[cont] > valor) {
                temp[cont] = temp[temp.length - 1];
                temp = Arrays.copyOf(temp, temp.length - 1);
            } else {
                cont++;
            }

        }
        return temp;
    }
}

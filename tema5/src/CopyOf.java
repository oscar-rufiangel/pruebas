
import java.util.Arrays;

public class CopyOf {

    public static void main(String[] args) {
        int [] t = {1, 2, 3, 4, 5, 6, 1, 5, 3, 6, 4, 7, 8, 4, 8, 1, 6};
        t = sinRepes(t);
        System.out.println(Arrays.toString(t));
    }

    static int [] sinRepes(int[] t) {
        int[] temp = new int[0];
        for (int i : t) {
            if (buscar(temp, i) == -1) {
                temp = Arrays.copyOf(temp, temp.length + 1); 
               temp[temp.length - 1] = i;
            }

        }
        return temp;
    }

    static int buscar(int [] t, int clave) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] == clave) {
                return i;
            }
        }
        return -1;
    }

}

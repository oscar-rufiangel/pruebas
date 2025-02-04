
import java.util.Arrays;

public class FuncionBorrar {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int borra = 6;
        System.out.println(Arrays.toString(borrarTablaOrd(t, borra)));
    }

    static int[] borrarTablaOrd(int t[], int borra) {
        int indiceb = Arrays.binarySearch(t, borra);
        if (indiceb >= 0) {
            System.arraycopy(t, indiceb + 1, t, indiceb, t.length - indiceb - 1);

            t = Arrays.copyOf(t, t.length - 1);
        }
        return t;
    }
}


import java.util.Arrays;
public class Diez {
    public static void main(String[] args) {
        int numeros[]= new int[25];
        for (int i = 0; i<numeros.length ; i++) {
            numeros[i]=i;
        }
        System.out.println(Arrays.toString(numeros));
    }
}

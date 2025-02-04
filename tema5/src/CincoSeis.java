
import java.util.Scanner;
import java.util.Arrays;

public class CincoSeis {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int apuesta[] = new int[6];
        int ganadora[] = {3, 6, 2, 12, 67, 35};
        Arrays.sort(ganadora);
        System.out.println("Vamos a comprobar la apuesta: ");
        for (int i = 0; i < apuesta.length; i++) {
            System.out.println("Escribe el numero en la : " + i + "º posición");
            apuesta[i] = sc.nextInt();
        }
        Arrays.sort(apuesta);
        System.out.println("La cantidad de numeros acertados es: " + aciertos(apuesta, ganadora));
    }

    static int aciertos(int apuesta[], int ganadora[]) {
        int cont = 0;
        for (int i:ganadora) {
            boolean comp= false;
            if (Arrays.binarySearch(apuesta,i)>= 0) {
                comp=true;
            }
            if(comp){cont++;}
        }
        return cont;
    }
}

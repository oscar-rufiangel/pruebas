
import java.util.Locale;
import java.util.Scanner;


public class CincoTres {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        sc.useLocale(Locale.US);
        double a[] = new double[5];
        for(int i=0;i<5;i++){
            System.out.println("Introduce el numero "+ (i+1) + ":");
            a[i]= sc.nextDouble();
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(a[i]+ " ");
        }
        System.out.println("");
    }
}

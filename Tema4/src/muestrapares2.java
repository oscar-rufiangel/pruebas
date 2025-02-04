import java.util.Scanner;

public class muestrapares2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero para ver todos sus pares");
        int n = sc.nextInt();
        muestraPares(n);
    }
    public static void  muestraPares (int n) {
    int contP = 2;
    int cont = 0;
    while (cont <= n) {
        System.out.println("El numero " + contP + " es par");
        contP +=2;
        cont++;
    }
        }
}

import java.util.Scanner;

public class MuestraNums {
    public static void main(String[] args) {
        int num3 = -1;
        int mayor;
        System.out.println("Introduce dos números: ");
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println("¿Quieres añadir otro numero?(si=1,no=2):");
        int op = sc.nextInt();
        if (op == 1) {
            num3 = sc.nextInt();
            mayor = comprendidos(num1, num2, num3);
        } else {
            mayor = comprendidos(num1, num2);
        }
        System.out.println("El numero mayor es: " + mayor);
        for (int i = mayor; i >= 0; i--) {
            if (i == num3 || i == num2 || i == num1) {
                System.out.print(" -----" + i + "----- ");
            }
            System.out.print(i + " ");
        }
    }

    static int comprendidos(int num1, int num2) {
        int mayor = Math.max(num1, num2);
        return mayor;
    }

    static int comprendidos(int num1, int num2, int num3) {
        int mayor;
        mayor = Math.max(comprendidos(num1, num2), num3);
        return mayor;

    }
}
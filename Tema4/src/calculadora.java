import java.util.Scanner;
import java.util.Locale;
public class calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        System.out.println("Escribe que dos números para operar");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        System.out.println("Escribe que operación quieres realizar: (-1- para sumar), (-2- para restar), (-3- para multiplicar), (-4- para dividir)");
        int op = sc.nextInt();
        switch (op) {
            case 1->suma(num1,num2);
            case 2->resta(num1,num2);
            case 3->multiplicacion(num1,num2);
            case 4->division(num1,num2);
        }
    }
    public static void suma(double num1, double num2) {
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
    }
    public static void resta(double num1, double num2) {
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
    }
    public static void multiplicacion(double num1, double num2) {
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
    }
    public static void division(double num1, double num2) {
        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
    }
}

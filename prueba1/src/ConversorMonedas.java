
import java.util.Scanner;

public class ConversorMonedas {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        opcion = menuMonedas(opcion);
        System.out.println("Escribe la cantidad que quieres cambiar de moneda.");
        double cantidad = sc.nextInt();
        switch (opcion) {
            case 1 -> {
                System.out.println("La cantidad de " + cantidad + "€ es: " + dolar(cantidad));
            }
            case 2 -> {
                System.out.println("La cantidad de " + cantidad + "€ es: " + libra(cantidad));
            }
            case 3 -> {
                System.out.println("La cantidad de " + cantidad + "€ es: " + yen(cantidad));
            }
            case 4 -> {
                System.out.println("La cantidad de " + cantidad + "€ es: " + rupia(cantidad));
            }
            case 5 -> {
                System.out.println("La cantidad de " + cantidad + "€ es: " + yuan(cantidad));
            }
            default -> {
                System.out.println("Hasta luego.");
            }

        }
    }

    static int menuMonedas(int opcion) {
        do {
            System.out.print("Elige a que moneda quieres hacer la conversión: "
                    + "\n1. Dolares(1$=0,90€)."
                    + "\n2. Libras(1£=1,21€)."
                    + "\n3. Yenes(1¥=0,0060234948€)."
                    + "\n4. Rupias(1₹=0,01€)."
                    + "\n5. Yuan(1¥=0,12€)."
                    + "\n6. Salir");
            opcion = sc.nextInt();
        } while (opcion > 6);
        return opcion;
    }

    static double dolar(double cantidad) {
        return cantidad*0.90;
    }

    static double libra(double cantidad) {
        return cantidad*1.21;
    }

    static double yen(double cantidad) {
        return cantidad*0.0060234948;
    }

    static double rupia(double cantidad) {
        return cantidad*0.01;
    }

    static double yuan(double cantidad) {
        return cantidad*0.12;
    }

}

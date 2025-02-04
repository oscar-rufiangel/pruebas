
import java.util.Scanner;

public class RegistroVentas {

    static Scanner sc = new Scanner(System.in);

    
    
    public static void main(String args[]) {
        int sumVentas = 0;
        int cont=0;
        
        
        int opcion;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1 -> {
                    sumVentas=agregarVenta(sumVentas,cont);
                    cont++;
                }
                case 2 -> {
                    mostrarTotalVentas(sumVentas,cont);
                }
                case 3 -> {
                    mostrarNumeroVentas(cont);
                }
                default -> {
                    opcion = 5;
                }
            }
        } while (opcion < 4);
    }

    static int mostrarMenu() {
        System.out.print("\n====Menú de registro de ventas===="
                + "\n1. Añadir nueva venta"
                + "\n2. Ver total de ventas"
                + "\n3. Ver números de ventas"
                + "\n4. Salir "
                + "\nElige una opción: ");
        int opcion = sc.nextInt();
        return opcion;
    }

    static int agregarVenta(int sumVentas, int cont) {
        
        System.out.println("Introduce el valor de la venta" );
        sumVentas += sc.nextInt();
        System.out.println("venta agregada. ");
        
        return sumVentas;
        
        
    }

    static void mostrarTotalVentas(int sumVentas, int cont) {
        System.out.println("\nEl total de las ventas es "+ sumVentas);
        
    }

    static void mostrarNumeroVentas(int cont) {
        System.out.println("\nEste ha sido el numero de ventas: "+cont);
        
        
    }
}

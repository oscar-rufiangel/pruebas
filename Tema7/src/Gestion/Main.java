package Gestion;

import java.awt.Event;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int opcion = 0;
        int id;
        String nombre = "hola";
        double precio;
        int cantidad;
        int idBuscar;
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique la capacidad maxima del inventario.");
        id = sc.nextInt();
        Inventario inventario = new Inventario(id);

        while (opcion < 5) {
            System.out.println("Escribe la accion a realizar"
                    + "\n1. Agregar un producto."
                    + "\n2. Consultar un producto por ID."
                    + "\n3. Eliminar un producto."
                    + "\n4. Mostrar todos los productos"
                    + "\n5. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    
                    System.out.print("Ingrese el ID del producto:");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\n Ingrese el nombre del producto: ");
                    nombre = sc.nextLine();
                    System.out.print("\n Ingrese el precio del producto: ");
                    precio = sc.nextDouble();
                    System.out.print("\nIngrese la cantidad del producto: ");
                    cantidad = sc.nextInt();
                    Productos p1 = new Productos(id, nombre, precio, cantidad);
                    inventario.añadirProducto(p1);
                }
                case 2 -> {
                    System.out.println("Escribe el id que quieres buscar: ");
                    idBuscar = sc.nextInt();
                    System.out.println(inventario.detallesProducto(idBuscar));
                }
                case 3 -> {
                    System.out.println("Escribe el id del producto a eliminar: ");
                    idBuscar = sc.nextInt();
                    inventario.eliminarProducto(idBuscar);
                }
                case 4 -> {
                    System.out.println(inventario);
                }
                default -> {
                    System.out.println("Saliendo del sistema...");
                }
            }
        }
    }
}

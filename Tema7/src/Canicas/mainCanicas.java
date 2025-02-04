package Canicas;

import java.net.SocketOptions;
import java.util.Scanner;

public class mainCanicas {
    public static void main(String[] args) {
        String nombre;
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe los dos jugadores.");
        System.out.print("Escribe el primer jugador: ");
        nombre=sc.nextLine();
        JugadoresCanicas jug1= new JugadoresCanicas(nombre);
        System.out.print("Escribe el nombre del segundo jugador: ");
        nombre=sc.nextLine();
        JugadoresCanicas jug2= new JugadoresCanicas(nombre);
        jug1.mostrarCanicas();
        jug2.comprarCanicas(10);
        jug1.mostrarCanicas();
        jug2.mostrarCanicas();
        jug1.quitarCanicas(4);
        jug2.mostrarCanicas();
    }
}

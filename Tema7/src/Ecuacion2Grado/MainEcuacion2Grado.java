package Ecuacion2Grado;

import java.util.Scanner;

public class MainEcuacion2Grado {

    public static void main(String[] args) {
        Ecuacion2Grado h = new Ecuacion2Grado(0, 0, 0);
        h.setA(2);
        h.setB(4);
        h.setC(6);
        h.mostrarSolucion();
    }

}

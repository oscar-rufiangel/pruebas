/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oscar.rufigl
 */
public class Nueve {

    public static void main(String[] args) {
        int numeros[] = new int[15];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 100 + 1);
            System.out.println(numeros[i]);
        }
        int maximo = numeros[0];
        int minimo = numeros[0];
        for (int numero : numeros) {
            if (maximo < numero) {
                maximo = numero;
            }
        }
        for (int numero : numeros) {
            if (minimo > numero) {
                minimo = numero;
            }
        }
        System.out.println("El numero maximo es: " + maximo + " y el minimo es: " + minimo);
    }
}

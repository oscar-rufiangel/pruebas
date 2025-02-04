package Hora;

import java.util.Scanner;

public class MainHora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hora h= new Hora();//Creamos el objeto Hora
        System.out.println("Hora: ");
        int valor=sc.nextInt();//leemos un valor para la hora.
        h.setHora(valor);
        System.out.println("Minuto: ");
        valor=sc.nextInt();//leemos un valor para la minuto.
        h.setMinuto(valor);
        System.out.println("Segundo: ");
        valor=sc.nextInt();//leemos un valor para la segundo.
        h.setSegundo(valor);
        System.out.println("Cuantos segundos quieres asignar");
        int numSegundos=sc.nextInt();
        for (int i = 0; i < numSegundos; i++) {
            System.out.println(h.getHora()+":"+h.getMinuto()+":"+h.getSegundo());
            h.incrementaSegundo();
        }
    }
}

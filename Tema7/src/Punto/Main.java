
package Punto;

public class Main {
    public static void main(String[] args) {
    Punto punto,otroPunto;
    punto = new Punto(0,0);
    otroPunto = new Punto(1,1);
        System.out.println(punto);
        System.out.println(otroPunto);
        System.out.println(punto.distanciaEuclidea(otroPunto));
        punto.despazaX(3);
        System.out.println(punto);
        punto.despazaY(3);
        System.out.println(punto);
        punto.despaza(4, 5);
        System.out.println(punto);
    }
    
}

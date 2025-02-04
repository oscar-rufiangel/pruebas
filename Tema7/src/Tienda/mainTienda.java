
package Tienda;

import java.util.Random;


public class mainTienda {
    public static void main(String[] args) {
        Random rand=new Random();
        Tienda sol=new Tienda("sol",0,0,0);
        Tienda atocha=new Tienda("atocha",0,0,0);
        sol.comprarChicle(rand.nextInt(20));
        sol.comprarCocaCola(rand.nextInt(20));
        sol.comprarDonut(rand.nextInt(20));
        sol.consultarVentasParciales();
        atocha.comprarChicle(rand.nextInt(20));
        atocha.comprarCocaCola(rand.nextInt(20));
        atocha.comprarDonut(rand.nextInt(20));
        atocha.consultarVentasParciales();
        System.out.println(sol);
    }
}

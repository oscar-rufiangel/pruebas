
package Bombilla;
public class MainBombilla {
    public static void main(String[] args) {
        Bombilla b1, b2;
        //Creamos las bombillas
        b1=new Bombilla();
        b2=new Bombilla();
        //Encendemos las bombillas
        b1.enciente();
        b2.enciente();
        //Compribamos las bombillas
        System.out.println("b1: "+b1.muestraEstado());
        System.out.println("b2: "+b2.muestraEstado());
        //Apagamos el interruptor general
        Bombilla.general=false;
        //Comprobamos otra vez
        System.out.println("b1: "+b1.muestraEstado());
        System.out.println("b2: "+b2.muestraEstado());
        //encendemos el interruptor general
        Bombilla.general=true;
        //apagamos las bombillas
        b1.apaga();
        b2.apaga();
        //mostramos bombillas
        System.out.println("b1: "+b1.muestraEstado());
        System.out.println("b2: "+b2.muestraEstado());
    }
}

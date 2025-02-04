
package Sumables;

public class Sumable {
    Object uno;

    public Sumable(Object uno) {
        this.uno = uno;
    }
    
    
    
    static boolean esNumero(Object ob){
    }
    
    void sumar(Object a, Object b){
        if(esNumero(a) && esNumero(b)){
            System.out.println(a+"+"+b+"="+(float)a+(float)b);
        }else if(a instanceof String && b instanceof String){
            System.out.println(""+a+b);
        }else{
            System.out.println("No es sumable");
        }
    }
}
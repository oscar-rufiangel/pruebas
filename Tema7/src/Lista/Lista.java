package Lista;

import java.util.Arrays;


public class Lista {
    Integer[] tabla;
    
    public Lista(){
        tabla=new Integer[0];
    }
    void insertarAlPrincipio(Integer nuevo){
        tabla= Arrays.copyOfRange(tabla,(tabla.length+1)-tabla.length,tabla.length+1);
    }
    void insertarAlFinal(Integer nuevo){
        tabla= Arrays.copyOf(tabla,tabla.length+1);
        tabla[tabla.length-1]=nuevo;
    }
}

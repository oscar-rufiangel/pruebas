package Canicas;


public class JugadoresCanicas {
    String nombreJugador;
    static int bolsaCanicas=0;
    
    public JugadoresCanicas(String nombreJugador){
        this.nombreJugador=nombreJugador;
    }
    void comprarCanicas(int cantidad){
        bolsaCanicas+=cantidad;
        System.out.println(nombreJugador + " compra " + bolsaCanicas + " canicas");
    }
    
    void quitarCanicas(int cantidad){
        bolsaCanicas-=cantidad;
        System.out.println(nombreJugador + " pierde " + bolsaCanicas + " canicas");
    }
    
    void mostrarCanicas(){
        System.out.println(nombreJugador + " mira la bolsa y ve " + bolsaCanicas + " canicas");
    }
}

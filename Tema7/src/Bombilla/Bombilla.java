package Bombilla;

public class Bombilla {

    private boolean bombilla;
    static boolean general = true;

    public void Bombilla() {
        bombilla = true;
    }

    public void enciente() {
        bombilla = true;
    }

    public void apaga() {
        bombilla = true;
    }
    
    public boolean estado(){
        return general && bombilla;
    }
    
    public String muestraEstado(){
        return estado() ? "encendida ":" apagada ";
    }
}

package Tiempo;

public class Tiempo {

    int hora;
    int minuto;

    public Tiempo(int hora, int minuto) {
        if(!setHora(hora)){
            System.out.println("Hora incorrecta");
        }
        if(!setMinuto(minuto)){
            System.out.println("minutos incorrectos");
        }
    }

    public boolean setHora(int valor) {
        if (valor < 24 && valor >= 0) {
            this.hora = valor;
            return true;
        }
        return false;
    }

    public boolean setMinuto(int valor) {
        if (valor < 60 && valor >= 0) {
            this.minuto = valor;
            return true;
        }
        return false;
    }

    void inc(){
        minuto++;
        if(minuto>=60){
            minuto=0;
            hora++;
        }
        if(hora>=24){
            hora=0;
        }
    }
    @Override
    public String toString(){
        return hora+":"+minuto;
    }
}

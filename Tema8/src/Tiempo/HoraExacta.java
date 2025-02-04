package Tiempo;


public class HoraExacta extends Tiempo{
    int segundo;
    public HoraExacta(int hora, int minuto, int segundo) {

        super(hora, minuto);
        if(!setSegundo(segundo)){
            System.out.println("segundo no valido");
        }
    }

    public boolean setSegundo(int valor) {
        if(valor <60 && valor >=0){
            this.segundo = valor;
            return true;
        }
        return false;
    }
    
    public void inc (){
        segundo++;
        if(segundo>60){
            segundo=0;
            super.inc();
        }
    }
    
    
    @Override
    public String toString(){
        return hora+":"+minuto+":"+segundo;
    }
}

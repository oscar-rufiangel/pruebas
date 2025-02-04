package Punto;


public class Punto {
    double x;
    double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    
    
    void despazaX(double dx){
        x=dx;
    }
    
    void despazaY(double dy){
        y=dy;
    }
    
    void despaza(double dx, double dy){
        x=dx;
        y=dy;
    }
    
    double distanciaEuclidea(Punto otro){
        return Math.sqrt(Math.pow((x-otro.x ),2)+Math.pow((y-otro.y),2));
    }
    
    public String toString(){
        return "La distancia en x es: "+x
                +"\n-------------------------"
                +"\nLa distancia en y es: "+y;
    }
}

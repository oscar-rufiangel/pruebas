
package Estacion.Personal;

public class Maquinista {
    String nombre;
    String DNI;
    double sueldo;
    String rango;

    public Maquinista(String nombre, String DNI, double sueldo, String rango) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.sueldo = sueldo;
        this.rango = rango;
    }
    
    public String toString(){
        return "Maquinista responsable: "+nombre+", rango "+ rango;
    }
            
}

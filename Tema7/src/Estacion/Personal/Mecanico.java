
package Estacion.Personal;

public class Mecanico {
    String nombre;
    int telefono;
    String especialidad;

    public Mecanico(String nombre, int telefono, String especialidad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }
    
    public String toString(){
        return nombre+", "+telefono+", especialidad: "+especialidad;
    }
}

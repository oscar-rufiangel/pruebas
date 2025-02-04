
package Estacion.Personal;

import java.util.Date;

public class JefeEstacion {
    String nombre;
    String DNI;
    Date FechaJefe;

    public JefeEstacion(String nombre, String DNI, Date FechaJefe) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.FechaJefe = FechaJefe;
    }
    public String toString(){
        return "Jefe de Estacion: "+nombre+", DNI: "+DNI+", Nombramiento: "+FechaJefe;
    }
    
}

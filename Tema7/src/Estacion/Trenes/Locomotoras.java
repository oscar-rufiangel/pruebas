
package Estacion.Trenes;

import Estacion.Personal.Mecanico;



public class Locomotoras {
    String matricula;
    int potencia;
    int antiguedad;
    Mecanico mec;

    public Locomotoras(String matricula, int potencia, int antiguedad, Mecanico mec) {
        this.matricula = matricula;
        this.potencia = potencia;
        this.antiguedad = antiguedad;
        this.mec = mec;
    }
    @Override
    public String toString(){
        return "Locomotora: "+matricula+"\nPotencia: "+potencia+"\nMecánico Asignado: "+mec;
    }
}

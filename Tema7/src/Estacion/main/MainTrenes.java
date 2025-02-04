
package Estacion.main;

import Estacion.Personal.JefeEstacion;
import Estacion.Personal.Maquinista;
import Estacion.Personal.Mecanico;
import Estacion.Trenes.Locomotoras;
import Estacion.Trenes.Trenes;
import java.util.Date;

public class MainTrenes {
    public static void main(String[] args) {
        Date fechaActual = new Date();
        JefeEstacion j1;
        Locomotoras l1;
        Maquinista m1;
        Trenes t1;
        Mecanico mec1;
        mec1=new Mecanico("juan paco", 111111111, "motor");
        j1=new JefeEstacion("juan garcia", "11111111q", fechaActual);
        l1=new Locomotoras("222-qwe", 1000, 1000, mec1);
        m1=new Maquinista("juan garcia", "11111111q", 100000, "JefeEstacion");
        t1=new Trenes(l1, m1);
        
        t1.enganchaVagones(1, 100, 50, "peines");
        t1.enganchaVagones(2, 200, 100, "rotuladores");
        t1.enganchaVagones(3, 300, 150, "vacas");
        System.out.println(j1+"\n"+t1);
    }
}

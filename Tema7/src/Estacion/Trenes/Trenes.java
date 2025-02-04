package Estacion.Trenes;

import Estacion.Personal.Maquinista;
import java.util.Arrays;

public class Trenes {

    Locomotoras locomotora;
    Vagones vagones[];
    Maquinista responsable;
    private int numVagones;

    public Trenes(Locomotoras locomotora, Maquinista responsable) {
        this.locomotora = locomotora;
        this.vagones = new Vagones[5];
        this.responsable = responsable;
        numVagones = 0;

    }

    public void enganchaVagones(int id, double cargaMax, double cargaAct, String mercancia) {
        if (numVagones >= 5) {
            System.out.println("El tren no admite mas vagones");
        } else {
            Vagones vagon = new Vagones(id, cargaMax, cargaAct, mercancia);
            vagones[numVagones] = vagon;
            numVagones++;
        }

    }

    @Override
    public String toString() {
        Vagones[] vagonesActivos = new Vagones[numVagones];
        System.arraycopy(vagones, 0, vagonesActivos, 0, numVagones);
        return locomotora + "\n \n" + responsable + "Vagones del tren: \n"
                + "" + (Arrays.toString(vagonesActivos).replace("[", "").replace("]", "").replace(",", ""));
    }
}

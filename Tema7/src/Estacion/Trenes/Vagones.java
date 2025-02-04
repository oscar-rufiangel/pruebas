
package Estacion.Trenes;

class Vagones {
    int id;
    double cargaMax;
    double cargaAct;
    String mercancia;

    public Vagones(int id, double cargaMax, double cargaAct, String mercancia) {
        this.id = id;
        this.cargaMax = cargaMax;
        this.cargaAct = cargaAct;
        this.mercancia = mercancia;
    }
    
    public String toString(){
        return "\n- Vagon "+id+": Carga maxima = "+cargaMax+", Carga actual = "+ cargaAct+", Mercancia = "+mercancia;
    }
}

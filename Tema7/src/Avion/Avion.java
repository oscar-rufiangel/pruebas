package Avion;

public class Avion {

    private int velocidad;
    private boolean trenAterrizaje;
    private boolean flaps;
    private boolean pilotoAutomatico;
    private String acelerometro;
    private String visorVelocidad;
    private final int retardo = 400;

    public Avion() {
        velocidad = 0;
        trenAterrizaje = true;
        flaps = false;
        pilotoAutomatico = false;
        acelerometro = "";
        visorVelocidad = "";
    }

    public void despegar() {
        imprimirAviso("ACTIVACION DE FLAGS PREVIO A DESPEGUE");
        flaps = true;
        imprimirAviso("VERIFICACION ANTES DE DESPEGUE");
        visualizarEstadoDelAvion();
        if (!revisarEstadoDelAvion()) {
            return;
        }
        imprimirAviso("TODO OK, LISTO PARA EL DESPEGUE");
        acelerar(250);
        volar();
    }

    private void acelerar(int velocidadFinal) {

        for (int i = 0; velocidad < velocidadFinal; i++) {

            try {
                Thread.sleep(retardo);

            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            if (velocidadFinal - velocidad < 50) {
                velocidad += velocidadFinal - velocidad;
            } else {
                velocidad += 50;
                acelerometro += ">\t";
            }
            if (velocidad >= 350 && trenAterrizaje) {
                imprimirAviso("RECOGER TREN DE ATERRIZAJE");
                trenAterrizaje = false;
            }
            if (velocidad >= 500 && flaps) {
                imprimirAviso("DESACTIVAR FLAGS");
                flaps = false;

            }
            System.out.println(acelerometro + velocidad + "\n");
        }
    }

    private void decelerar() {

        acelerometro = acelerometro.replaceAll(">", "<");
        for (int i = 0; velocidad > 0; i++) {

            try {
                Thread.sleep(retardo);

            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

            if (velocidad < 50) {
                velocidad = 0;
            } else {
                velocidad -= 50;
                acelerometro = acelerometro.replaceFirst("<\t", "");
            }
            if (velocidad <= 350 && !trenAterrizaje) {
                imprimirAviso("ACTIVAR TREN DE ATERRIZAJE");
                trenAterrizaje = true;
            }
            if (velocidad <= 500 && !flaps) {
                imprimirAviso("ACTIVAR FLAGS");
                flaps = true;
            }
            System.out.println(acelerometro + velocidad + "\n");
        }
    }

    private void volar() {
        imprimirAviso("ACELERANDO HASTA VELOCIDAD DE CRUCERO(900km/h)");
        acelerar(900);
        imprimirAviso("ACTIVAR PILOTO AUTOMATICO");
        pilotoAutomatico = true;
        imprimirAviso("VOLANDO VOLANDO VOLANDO");

        aterrizar();
    }

    private void aterrizar() {
        imprimirAviso("APROXIMANDONOS A DESTINO");
        imprimirAviso("DESACTIVAR PILOTO AUTOMATICO");
        pilotoAutomatico = false;
        imprimirAviso("DECELERANDO HASTA VELOCIDAD DE ATERRIZAJE(100KM/H)");
        decelerar();
        imprimirAviso("DESACTIVAR FLAGS");
        visualizarEstadoDelAvion();
        imprimirAviso("INICIO DESEMBARCO DE PASAJEROS");
    }

    private void visualizarEstadoDelAvion() {
        System.out.println(
                "\nvelocidad.............." + velocidad
                + "\ntren de aterrizaje....." + trenAterrizaje
                + "\nflags.................." + flaps
                + "\npiloto automatico......" + pilotoAutomatico
        );
    }

    private boolean revisarEstadoDelAvion() {
        if (velocidad == 0 && trenAterrizaje && flaps && !pilotoAutomatico) {
            return true;
        }
        return false;
    }

    private void imprimirAviso(String aviso) {
        System.out.println("-------------------------------------------");
        System.out.println(aviso);
        System.out.println("-------------------------------------------");
    }
}

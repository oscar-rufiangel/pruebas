package CuentaCorriente;


public class Gestor {
    public String nombre;
    private String tlf; //es un número con el que no se opera: es usual usar String
    double importeMax; //visibilidad por defecto

    public Gestor(String nombre, String tlf, double importeMax) {
        this.nombre = nombre;
        this.tlf = tlf;
        this.importeMax = importeMax;
    }

    public Gestor(String nombre, String tlf) {
        this(nombre, tlf, 10000.0); //asignamos el importe máximo por defecto: 10000 euros
    }

    String getTlf() { //al ser tlf privado permite consultar el teléfono de un gestor
        return tlf;
    }

    void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Teléfono: " + tlf);
        System.out.println("Importe máximo: " + importeMax + " euros");
    }
}
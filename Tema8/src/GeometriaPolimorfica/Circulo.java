package GeometriaPolimorfica;

public class Circulo extends Forma {

    int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    @Override
    double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    void mostrarTipo() {
        System.out.println("Soy un circulo"
                + "\nArea: " + calcularArea());
    }

}

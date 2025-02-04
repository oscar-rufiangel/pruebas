package GeometriaPolimorfica;

public class Rectangulo extends Forma {

    double altura;
    double base;

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public Rectangulo(double altura, double base) {
        this.altura = altura;
        this.base = base;
    }

    @Override
    double calcularArea() {
        return base * altura;

    }

    @Override
    void mostrarTipo() {
        System.out.println("Soy un Rectangulo"
                + "\nArea: " + calcularArea());
    }

}

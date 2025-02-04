package GeometriaPolimorfica;

public class Triangulo extends Rectangulo {

    double altura;
    double base;

    public Triangulo(double altura, double base) {
        super(altura, base);
//Esto llama al constructor de la super clase rectangulo, 
//y utiliza ese constructor para crear el objeto triangulo con los parametros que le pasamos
    }

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

    double calcularArea() {//Aqui se ejecuta el metodo de calcular area de rectangulo. Que es la supreclase.
        return super.calcularArea();
    }

    @Override
    void mostrarTipo() {
        System.out.println("Soy un Triangulo"
                + "\nArea: " + calcularArea());
    }
}

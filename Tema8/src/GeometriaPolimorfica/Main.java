package GeometriaPolimorfica;

public class Main {

    public static void main(String[] args) {
        Forma[] areas = new Forma[3];
        Circulo a;
        Rectangulo b;
        Triangulo c;
        a = new Circulo(10);
        b = new Rectangulo(5, 8);
        c = new Triangulo(2, 4);
        areas[0] = a;
        areas[1] = b;
        areas[2] = c;
        for (int i = 0; i < areas.length; i++) {
            areas[i].mostrarTipo();
        }
    }
}

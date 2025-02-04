import java.util.Scanner;

public class euclide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vamos a realizar la ecuacion de distancia euclidea");
        System.out.println("Escribe la primera coordenada:");
        System.out.print("\nEscribe la coordenada x1");
        double x1 = sc.nextDouble();
        System.out.print("\nEscribe la coordenada y1");
        double y1 = sc.nextDouble();
        System.out.print("\nEscribe la coordenada x2");
        double x2 = sc.nextDouble();
        System.out.print("\nEscribe la coordenada y2");
        double y2 = sc.nextDouble();
        System.out.println(distancia(x1, y1, x2, y2));
    }
    static double distancia(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}

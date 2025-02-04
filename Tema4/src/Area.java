import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Escriba 1 si quiere calcular el area de un cilindro. \n Escriba 2 si quiere calcular el volumen de un cilindro");
            opcion = sc.nextInt();
        }while(opcion <1 || opcion >2);
        System.out.println("Escriba el valor de radio:");
        int radio = sc.nextInt();
        System.out.println("Escriba el valor de altura:");
        int altura = sc.nextInt();
        if (opcion == 1) {area( radio, altura);}else{volumen(radio,altura);}
    }
    static void area (int radio, int altura){
        System.out.println("El area del cilindro es: " + 2*Math.PI*(radio+altura));
    }
    static void volumen (int radio, int altura){
        System.out.println("El volumen del cilindro es: " + Math.PI*radio*radio*altura);
    }
}

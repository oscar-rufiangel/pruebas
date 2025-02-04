
import java.util.Scanner;

public class SumaVentas {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
//Aquí introducimos cuantos precios queremos añadir
        System.out.println("Introdudce el numero de precios");
        int numPrecios = sc.nextInt();
        double sumaNum = calcularTotal(0, numPrecios);//aqui calculamos la suma de los precios
        System.out.println(Descuento(sumaNum));//Aquí mostramos en caso de que la suma de los precios sea mayor a 100 hará el 10%
    }

    static double calcularTotal(double sumaNum, double numPrecios) {//Con este metodo calculamos los precios
        Scanner sc = new Scanner(System.in);
        if (numPrecios < 1) {
            return sumaNum;
        }
        
        double precio = pedirPrecio();//Llammamos al metodo que pide los numeros.

        return calcularTotal(sumaNum + precio, numPrecios - 1);//volvemos a llamar al metodo de forma recursiva para seguir sumando numeros.
    }

    static double pedirPrecio() {//Metodo que calcula los precios y te pide siempre hasta que des un precio valido.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe un precio");
        double precio = scanner.nextDouble();
        while (precio <= 0) {
            System.out.print("Pon un precio valido. ");
            System.out.println("Escribe un precio");
            precio = scanner.nextDouble();
        }
        return precio;
    }
    static double Descuento(double sumaNum){//calcula el descueto en caso de que sea necesario.
        if (sumaNum>=100){
            return sumaNum*0.9;
        }else{
            return sumaNum;
        }
    }
}

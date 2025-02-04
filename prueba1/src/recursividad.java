
import java.util.Scanner;


public class recursividad {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Introduce un numero real para la base");
        double N= sc.nextInt();
        System.out.println(" Introduce un numero entero positivo para el exponente");
        int M= sc.nextInt();
        System.out.println(potencia(N,M));
    }
    static double potencia (double N,int M){
      if (M == 0){
          return 0;
      }else 
          return N* potencia(N,M-1);
    }
}

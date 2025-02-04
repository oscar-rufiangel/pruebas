
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CamaraSecreta {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Escribe la longitud del numero secreto");
        int longi = sc.nextInt();
        int[] combinacionSecreta = generaCombinacion(longi);
        leeTabla(combinacionSecreta);
    }

    static int[] generaCombinacion(int longi) {
        int[] Combinacion = new int[longi];
        for (int i = 0; i < longi; i++) {
            Combinacion[i] = random.nextInt(1, 6);
        }
        return Combinacion;
    }

    static void leeTabla(int[] combinacionSecreta) {
        int [] combinacion=new int[combinacionSecreta.length];
        for (int i = 0; i < combinacion.length; i++) {
            do {
                System.out.println("Introduce un numero, del 1 al 5: ");
                combinacion[i] = sc.nextInt();
                
                if (combinacion[i] < 1 || combinacion[i] > 5) {
                    System.out.println("el numero es incorrecto");
                }
                
            } while (combinacion[i] < 1 || combinacion[i] > 5);
        }
        if (Arrays.equals(combinacion, combinacionSecreta)){
            System.out.println("¡¡Has ganado!!"); 
        }else{
            muestraPistas(combinacionSecreta,combinacion);
            leeTabla(combinacionSecreta);
        }
    }
    
    static void muestraPistas(int[]combinacionSecreta,int[]combinacion){
        for (int i = 0; i < combinacionSecreta.length; i++) {
            if(combinacionSecreta[i]>combinacion[i]){
                System.out.println("El numero "+combinacion[i]+ " es mayor");
            }else if(combinacionSecreta[i]<combinacion[i]){
                System.out.println("El numero "+combinacion[i]+ " es menor");
            }else {
                System.out.println("El numero "+combinacion[i]+ " es igual");
            }
        }
    }
}

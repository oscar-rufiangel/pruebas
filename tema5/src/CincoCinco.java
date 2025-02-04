
import java.util.Arrays;
import java.util.Scanner;

public class CincoCinco {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Escribe el tamaño de la lista:");
        int longi = sc.nextInt();
        System.out.println("Ahora escribe el valor par maximo que admite: ");
        int fin = sc.nextInt();
        System.out.println(Arrays.toString(rellenaPares(longi, fin)));
    }

    static int[] rellenaPares(int longi, int fin) {
        int numeros[]= new int[longi];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i]=parRandom(fin);
            
        }
        return numeros;
    }
    static int parRandom (int fin){
        int otroRandom=(int) (Math.random()*fin+1);
        if(otroRandom%2==0){
            return otroRandom;
        }
        return parRandom(fin);
    }
}

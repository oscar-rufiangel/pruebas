
import java.util.Scanner;


public class CincoDos {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int positivo=0;
        int sumpositivo=0;
        int sumnegativo=0;
        int negativo=0;
        int cont0=0;
        System.out.println("Escribe la cantidad de numeros que quieres comparar.");
        int n= sc.nextInt();
        int numeros[]= new int[n];
        
        for (int i=0;i<n;i++) {
            System.out.println("Escribe un numero:");
            numeros[i]=sc.nextInt();
        }
        for(int numero:numeros){
            if (numero>0){
                positivo++;
                sumpositivo+=numero;
            }else if (numero<0){
                negativo++; 
                sumnegativo+=numero;
            }else{
                cont0++;
            }

        }
        System.out.println("La media de los numeros positivos es: "+ sumpositivo/positivo);
        System.out.println("La media de los numeros negativos es: "+ sumnegativo/negativo);
        System.out.println("La cantidad de 0 introducidos son: "+ cont0);
    }
}

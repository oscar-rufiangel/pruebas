/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/
package prueba1;
 
import java.util.Scanner;
public class ClaseWhileFor {
    public static void main(String[] args) {
        //1.- Introducir un numero (1..100)
        //suma de numeros pares desde 0 hasta ese numero
        //media de los impares
        // cuantos numeros pares? cuantos numeros impares?
//        System.out.println("Introduce un numero entre 1 y 100: ");
        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
        int num;
        int SumP = 0;
        int SumI = 0;
        int Imp = 0;
        int Par = 0;
        do{
            System.out.println("Introduce un numero entre 1 y 100 ");
            num = sc.nextInt();
        }while (num<=1 || num>=100);
        for (int i=1; i<=num;i++){
            if (i%2==0){
                SumP += i;
                Par++;
            }else {
                SumI += i;
                Imp++;
            }
        }
        System.out.println("La suma de los numeros pares es " + SumP);
        System.out.println("El total de numeros pares es "+ Par);
        System.out.println("El total de numeros impares es " + Imp);
        System.out.println("La media de numeros impares es "+ (double)SumI/Imp);
    }
 
}
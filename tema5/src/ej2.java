
import java.util.Arrays;
import java.util.Scanner;

public class ej2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String palabra = sc.nextLine();
        contLetras(palabra);
    }

    static void contLetras(String palabra) {
        int contV = 0;
        int contC = 0;
        char[] vocales = {'a', 'e', 'i', 'o', 'u','á','é','í','ó','ú'};
        for (char charac : palabra.toCharArray()) {
            if(!Character.isLetter(charac)){
                continue;
            }
            if (Arrays.binarySearch(vocales, Character.toLowerCase(charac)) >=0) {
                contV++;
            } else {
                contC++;
            }
        }
        System.out.println(contV +" "+ contC);

        
    }

}

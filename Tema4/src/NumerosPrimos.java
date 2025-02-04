import java.util.Scanner;

public class NumerosPrimos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (esPrimo(num)) {
            System.out.println("El numero " + num + " es primo");
        } else {
            System.out.println("El numero " + num + " no es primo");
        }
    }

//    static boolean esPrimo(int num) {
//        int cont = 0;
//        for (int i = 2; i <= num; i++) {
//            if (num % i == 0) {
//                cont++;
//            }
//        }
//        if (cont > 1) {
//            return false;
//        } else {
//            return true;
//        }
        static boolean esPrimo(int num){
            int cont = 0;
            for (int i = 2; i <= num; i++) {
                if (num % i == 0) {
                    cont++;
                }
            }
            if (cont > 1) {
                return false;
            } else {
                return true;
            }
        }
    }


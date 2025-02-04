
import java.util.Scanner;


public class CincoCuatro {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int [] t= {1,4,2,5,23,6,4,2,7,4,6};
        System.out.println("El numero maximo es: "+ maximo(t));
    }
    static int maximo(int t[]){
        if(t.length==0){
            return 0;
        }
        int maximo=t[0];
        for(int numero:t){
            if(maximo<numero){
                maximo=numero;
            }
        }
        return maximo;
    }
}

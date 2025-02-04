
import java.util.Arrays;
import java.util.Scanner;


public class copyOfRange {
    public static void main(String[] args) {
        int [] t = {1, 2, 3, 4, 21, 6, 1, 5, 3, 6, 4, 7, 8, 4, 8, 1, 6,20,30,40,50,60,70,80,90};
        int desde=pedirNumeroArrays(t);
        int hasta=pedirNumeroArrays(t);
        t = sinRepes(t,desde,hasta);
        System.out.println(Arrays.toString(t));
    }
        static int [] sinRepes(int[] t, int desde,int hasta) {
        int[] temp = new int[0];
        for (int i=0;i<hasta-desde+1;i++) {
            if (buscar(temp, t[i+desde]) == -1) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = t[i+desde];
            }

        }
        return temp;
    }

    static int buscar(int [] t, int clave) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] == clave) {
                return i;
            }
        }
        return -1;
    }
    static int pedirNumeroArrays (int [] t){
        Scanner sc = new Scanner(System.in);
        System.out.println("Estribe un numero para inicializar/finalizar el array");
        int num = sc.nextInt();
        if(num<0 || num>t.length){
            return 0;
        }else{
            return num;
        }
    }
}

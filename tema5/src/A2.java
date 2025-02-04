
import java.util.Scanner;

public class A2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Escribe Dos frases. "
                + "\n Escribe la primera frase");
        String uno= sc.nextLine();
        System.out.println("Escribe la segunda frase. ");
        String dos= sc.nextLine();
        if(uno.equalsIgnoreCase(dos)){
            System.out.println("Ambos son iguales");
        }else{
            System.out.println(uno.toUpperCase()+" "+dos.toUpperCase()
                    + "\n O \n"
                    + ""+ dos.toUpperCase()+" "+uno.toUpperCase());
        }
    }
}


import java.util.Scanner;


public class Fin {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String fraseFinal="";
        System.out.println("Escribe una palabra, para acabar escribe fin");
        String palabra=sc.nextLine();
        while(!palabra.equalsIgnoreCase("fin")){
            fraseFinal+= " "+palabra;
        System.out.println("Escribe otra palabra, para acabar escribe fin");
        palabra=sc.nextLine();    
        }
        System.out.println(fraseFinal.strip());
    }
}

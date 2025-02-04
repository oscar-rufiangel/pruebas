
import java.util.Scanner;

public class JavalinJavalon {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final String prefijo = "javalín,javalón";
        final String sufijo = "javalén,len,len";
        boolean javanes = false;
        System.out.println("Escribe una frase");
        String frase = sc.nextLine();
        if (frase.startsWith(prefijo)) {
            javanes = true;
            frase = frase.substring(prefijo.length());

        } else if (frase.endsWith(sufijo)) {
            javanes = true;
            frase = frase.substring(0, frase.length() - sufijo.length());

        }
        if (javanes) {
            frase = frase.strip();
        }
        System.out.println(frase);
    }
}

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author oscar
 */

public class AlmacenDePapaNoel {

    static Scanner sc = new Scanner(System.in);  // Scanner para leer la entrada del usuario
    static Random random = new Random();  // Generador de números aleatorios
    static char[] caracteres = {'1', '2', '3', 'a', 'b', 'c'};  // Array de caracteres permitidos

    public static void main(String[] args) {
        final String combinacionSecreta = CrearCombinacion();  // Genera la combinación secreta al iniciar el programa
        int cont = 5;  // Número de intentos permitidos
        String intento = "";  // Variable para almacenar el intento del usuario
        System.out.println("Bienvenido a la fabrica de Papa Noel, tienes que adivinar su codigo de entrada"
                + "\n para entrar en su fabrica y coger los regalos");
        // Bucle que continúa hasta que se adivine la combinación secreta o se agoten los intentos
        while (!combinacionSecreta.equalsIgnoreCase(intento) && cont > 0) {
            intento = ComprobarIntentoValido(intento);  // Comprueba que el intento del usuario sea válido
            if (!combinacionSecreta.equalsIgnoreCase(intento)) {
                ComprobacionCorrecto(intento, combinacionSecreta);  // Comprueba el intento del usuario y da pistas
                System.out.println("Te quedan " + --cont + " intentos");
            }
        }
        // Mensaje final si se adivina la combinación secreta
        if (cont > 0) {
            System.out.println("============================================================================================================"
                    + "\nHas acabado el codigo era " + combinacionSecreta + " Ahora recoge tu recompensa y coge todos los regalos que quieras");
        }else{
            System.out.println("Perdiste, no has podido abrir el alamacen y papa noel te va a dejar sin regalos");
        }
    }

    // Método para comprobar si el intento del usuario es válido
    static String ComprobarIntentoValido(String intento) {
        boolean valido = false;

        while (!valido) {
            System.out.println("\nEl código tiene 4 caracteres con las letras (a, b, c) y los números (1, 2, 3)"
                    + "\nTienes 10 intentos antes de que la puerta se bloquee y te quedes sin regalos por intentar robar a Papá Noel\n");
            intento = sc.nextLine().toLowerCase();
            char[] intentoChar = intento.toCharArray();

            if (intento.length() == 4) {
                valido = true;  // Asume que el intento es válido
                for (char letra : intentoChar) {
                    if (Arrays.binarySearch(caracteres, letra) < 0) {
                        valido = false;  // Si algún carácter no es válido, el intento no es válido
                        break;
                    }
                }
                if (!valido) {
                    System.out.println("Intento inválido, utiliza solo las letras (a, b, c) y los números (1, 2, 3). Inténtalo de nuevo.");
                }
            } else {
                System.out.println("El código debe tener exactamente 4 caracteres. Inténtalo de nuevo.");
            }
        }

        return intento;  // Devuelve el intento válido
    }

    // Método para comprobar si los caracteres del intento del usuario están en la combinación secreta
    static void ComprobacionCorrecto(String tries, String combinacion) {
        char[] intento = tries.toCharArray();
        char[] combinacionSecreta = combinacion.toCharArray();
        for (int i = 0; i < combinacionSecreta.length; i++) {

            if (intento[i] == combinacionSecreta[i]) {
                System.out.println("El digito " + combinacionSecreta[i] + " Es correcto");
            } else if (combinacion.indexOf(intento[i]) > -1) {
                System.out.println("El digito " + intento[i] + " es correcto pero no está en la posicion correcta");
            } else {
                System.out.println("El digito " + intento[i] + " no es correcto");
            }
        }
    }

    // Método para generar una combinación secreta aleatoria
    static String CrearCombinacion() {
        String combinacionSecreta = "";
        char randomChar = 'n';

        for (int i = 0; i < 4; i++) {
            randomChar = caracteres[random.nextInt(0, 5)];  // Selecciona un carácter aleatorio del array
            while (combinacionSecreta.indexOf(randomChar) > -1) {
                randomChar = caracteres[random.nextInt(0, 5)];  // Selecciona otro carácter si ya está en la combinación
            }
            combinacionSecreta += randomChar;  // Añade el carácter a la combinación secreta
        }
        return combinacionSecreta;  // Devuelve la combinación secreta generada
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Ahoracado {

    static Scanner sc = new Scanner(System.in);  // Escáner para leer la entrada del usuario

    public static void main(String[] args) {
        String intPalabra="";
        char intento = 'n';  // Caracter de intento inicializado
        int cont = 7;  // Contador de intentos
        String resultado = "";
        System.out.println("Escribe una palabra para jugar al ahoracado");
        String palabra = sc.nextLine();  // Lee la palabra para jugar
        char[] palabraArray = palabra.toCharArray();  // Convierte la palabra en un array de caracteres
        char[] palabraFin = new char[palabraArray.length];  // Array para almacenar los caracteres adivinados
        char[] temp = new char[palabraArray.length];  // Array temporal para comparar cambios
        System.out.println("La palabra tiene :"
                + "\n" + "_ ".repeat(palabra.length()));  // Muestra guiones bajos como representación de la palabra
        while (!palabra.equalsIgnoreCase(resultado) && cont > 0) {  // Bucle principal del juego
            System.out.println("Intenta adivinar la palabra, si quieres escribir una letra escribela"
                    + "\n si quieres intentar adivinar la palabra escribe un numero para hacer el intento(si fallas contará como un fallo).");
            intento = sc.nextLine().toLowerCase().toCharArray()[0];  // Lee el intento del usuario
            if (Character.isDigit(intento)) {  // Verifica si el intento es un número
                System.out.println("Estas en el menú de adivinar la palabra, escribe la palabra que creas correcta");
                intPalabra = sc.nextLine();  // Lee la palabra completa como intento
                resultado = intPalabra;
            } else {
                temp = Arrays.copyOf(palabraFin, palabraFin.length);  // Copia el estado actual de palabraFin en temp

                IntroducirLetra(palabraArray, intento, palabraFin);  // Introduce la letra en la palabra si es correcta

                MostrarLetras(palabraArray, palabraFin);  // Muestra las letras adivinadas y los guiones bajos

                resultado = String.valueOf(palabraFin);  // Convierte palabraFin a String para comparación
            }
            if (Arrays.equals(temp, palabraFin) && !intPalabra.equals(palabra)) {  // Verifica si no hubo cambios en palabraFin o si el intento de la palabra es incorrecto.
                cont--;  // Decrementa el contador de intentos
                System.out.println("Te quedan 7/" + cont + "intentos");
            }
        }

        if (cont > 0) {  // Verifica si el jugador ganó
            System.out.println("Enhorabuena la palabra era " + palabra);
        } else {  // Verifica si el jugador perdió
            System.out.println("OH, perdiste la palabra correcta era " + palabra);
        }
    }

    static char[] IntroducirLetra(char[] palabraArray, char intento, char[] palabraFin) {
        for (int i = 0; i < palabraArray.length; i++) {  // Recorre la palabra original
            if (intento == palabraArray[i]) {  // Si la letra intentada está en la palabra
                palabraFin[i] = palabraArray[i];  // La agrega al array de la palabra final
            }
        }
        return palabraFin;  // Retorna la palabra final actualizada
    }

    static void MostrarLetras(char[] palabraArray, char[] palabraFin) {
        for (int j = 0; j < palabraFin.length; j++) {  // Recorre la palabra final
            if (palabraFin[j] == palabraArray[j]) {  // Si la letra es correcta
                System.out.print(palabraArray[j] + " ");  // Imprime la letra
            } else {
                System.out.print("_ ");  // Imprime un guion bajo si la letra no ha sido adivinada
            }
        }
        System.out.println("");  // Salto de línea para mejor legibilidad
    }
}

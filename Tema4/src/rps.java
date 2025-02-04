import java.util.Random;
import java.util.Scanner;

public class rps {

    public static void main(String[] args) {
        int cont = 0;
        int contP = 0;
        int contCPU = 0;
        String opcion;
        Scanner sc = new Scanner(System.in);
        System.out.println("Vamos a jugar a piedra, papel o tijera\n");

        do {

            String botOpcion = bot();//Asignamos el valor del metodo a una variable para que el valor solo cambie al acabar el bucle.

            System.out.println("Escribe una opción: piedra, papel o tijera.\nSi quieres salir, escribe salir.");
            opcion = sc.nextLine().toLowerCase();//Convertimos la opcion del usuario en minusculas para que se pueda comparar correctamente.
            System.out.println("El bot ha elegido: " + botOpcion);//Muestra la opcion que ha elegido el bot.
            if (opcion.equals("piedra") || opcion.equals("papel") || opcion.equals("tijera")) {
                String resultado = Combate(opcion, botOpcion);
                System.out.println(resultado);

                if (resultado.equals("Has ganado")) {
                    contP++;
                } else if (resultado.equals("Has perdido")) {
                    contCPU++;
                }//IF para saber quien ha ganado.
                cont++;

                if (cont % 3 == 0) {//Cada 3 comparaciones aparecerá un mensaje con quien ha ganado.
                    if (contCPU > contP) {
                        System.out.println("El combate ha acabado. Has perdido " + contP + "/" + contCPU + "\n");
                    } else if (contP > contCPU) {
                        System.out.println("El combate ha acabado. Has ganado " + contP + "/" + contCPU + "\n");
                    } else {
                        System.out.println("El combate ha acabado en empate " + contP + "/" + contCPU + "\n");
                    }

                }
            } else if (!opcion.equals("salir")) {//Si la opcion no es valida
                System.out.println("Opción no válida.");
            }

        } while (!opcion.equals("salir"));
        System.out.println("Hasta luego");
    }

    public static String bot() {//Este metodo elige una palabra aleatoria.
        String[] x = {"piedra", "papel", "tijera"};
        Random rand = new Random();
        int random = rand.nextInt(3);
        return x[random];
    }

    public static String Combate(String opcion, String botOpcion) {
        if (botOpcion.equals("tijera") && opcion.equals("piedra")) {//gana el usuario
            return "Has ganado";
        } else if (botOpcion.equals("tijera") && opcion.equals("papel")) {//gana el bot
            return "Has perdido";
        } else if (botOpcion.equals("piedra") && opcion.equals("tijera")) {//gana el bot
            return "Has perdido";
        } else if (botOpcion.equals("piedra") && opcion.equals("papel")) {//gana el usuario
            return "Has ganado";
        } else if (botOpcion.equals("papel") && opcion.equals("piedra")) {//gana el bot
            return "Has perdido";
        } else if (botOpcion.equals("papel") && opcion.equals("tijera")) {//gana el usuario
            return "Has ganado";
        } else if (botOpcion.equals(opcion)) {
            return "Empate";
        } else {
            return "No válido";
        }//if del combate
    }//string Combate
}//Public class
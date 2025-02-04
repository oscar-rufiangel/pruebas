import java.util.Scanner;
//Programa para saber si una letra es una vocal
public class Vocales {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe una letra: ");
        char letra = sc.next().charAt(0);//Creamos una variable de tipo carácter.
        Vocal(letra);//Llamamos a la función "vocal" pasandole la variable de nuestra letra

        boolean resultado = Vocal(letra);
        if (resultado){ System.out.println("La letra " + letra + " es una vocal ");
        }else {System.out.println("La letra " + letra + " es una consonante ");}
    }//void main
    static boolean Vocal(char letra) {
//Creamos la variable para saber si es verdadero o falso
        boolean resultado;
//Comparamos para saber si es alguna vocal
        if (letra == 'A'||letra == 'E'||letra == 'I'||letra == 'O'||letra == 'U'||letra == 'a'||letra == 'e'||letra == 'i'||letra == 'o'||letra == 'u') {
            resultado = true;
        }else{
            resultado = false;
        }
        return resultado;
    }//boolean Vocal
}//public class

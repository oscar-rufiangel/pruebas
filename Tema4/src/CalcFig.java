import java.util.Scanner;
//Programa para calcular las distintas operaciones de las figuras.
public class CalcFig {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        System.out.print("Escriba el radio que quiere utilizar: \n");
        double radio = sc.nextDouble();
//Creamos un bucle para que nos pida siempre que operación quiere realizar hasta que escriba un 8 o mas.
        do {
            System.out.println("Escriba que desea realizar:" +
                    "\n ·(-1-)Calcular la longitud de una circunferencía." +
                    "\n ·(-2-)Calcular el area de una esfera." +
                    "\n ·(-3-)Calcular el area de una esfera." +
                    "\n ·(-4-)Calcular el area de un cilindro. " +
                    "\n ·(-5-)Calcular el volumen de una esfera." +
                    "\n ·(-6-)Calcular el volumen de un cilindro." +
                    "\n ·(-7-Volver a escribir el radio." +
                    "\n ·(-8-Salir del programa.)");
            op=sc.nextInt();
            switch (op) {
                case 1 -> LongCircunferencia(radio);
                case 2 -> AreaCirc(radio);
                case 3 -> AreaEsf(radio);
                case 4 -> AreaCil(radio);
                case 5 -> VolEsf(radio);
                case 6 -> VolCil(radio);
                case 7 -> {
                    System.out.print("Escribe un nuevo radio :");
                    radio = sc.nextInt();
                }
                default -> System.out.println("Hasta luego");
            }
        }while(op<8);
    }//void main
    public static void LongCircunferencia(double radio) {
        System.out.println("\nVamos a calcular la longitud de una circunferencía.");
        System.out.println("La longitud es: 2*π*r=" + (2 * Math.PI * radio)+" \n ");//realizamos la operación
    }//void LongCircunferencia
    public static void AreaCirc(double radio) {

        System.out.println("\nVamos a calcular el area de una circunferencia.");
        System.out.println("El area es: π*r^2="+ (Math.PI*Math.pow(radio,2)) +"\n");//realizamos la operación
    }//void AreaCirc
    public static void AreaEsf(double radio) {
        System.out.println("\nVamos a calcular el area de una esfera.");
        System.out.println("El area es: 4πr^2= "+(4*Math.PI*Math.pow(radio,2)) +"\n");//realizamos la operación
    }//void AreaEsf
    public static void AreaCil(double radio) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nVamos a calcular el area de un cilindro.Por favor escriba la altura:");
        double altura= sc.nextInt();//Aquí primero pedimos la altura que es necesaria para la operación.
        System.out.println("El area es: 2*π*(r+h)= "+ 2*Math.PI*(radio+altura) +"\n");//realizamos la operación
    }//void AreaCil
    public static void VolEsf(double radio) {
        System.out.println("\nVamos a calcular el volumen de una esfera. ");
        System.out.println("El volumen de es: 4/3*π*r^3= " + 4/3*Math.PI*Math.pow(radio,3)+"\n");//realizamos la operación
    }//Void VolEsf
    public static void VolCil(double radio) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nVamos a calcular el volumen de un cilindro.");
        System.out.println("\n Ahora escriba la altura: ");
        double altura=sc.nextDouble();//Aquí primero pedimos la altura que es necesaria para la operación.
        System.out.println("\n El volumen de un cilindro es: π*r^2*h "+Math.PI*Math.pow(radio,2)*altura+"\n");//realizamos la operación
    }//Void VolCil
}//Public class

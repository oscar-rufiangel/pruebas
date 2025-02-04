package CuentaCorriente;


import CuentaCorriente.Gestor;
import java.util.Scanner;

public class CuentaCorriente {
    String dni; //del titular
    public String nombre; //del titular
    double saldo; //efectivo disponible en la cuenta

    static private String nombreBanco="Internacional Java Bank";
    static void setBanco(String nuevoNombre){
        nombreBanco=nuevoNombre;
    }
    static String getBanco(){
        return nombreBanco;
    }
    //los parámetros de entrada: nombre y dni, ocultan a los atributos de la clase
    //con el mismo identificador. Para acceder a ellos hay que utilizar this.
    CuentaCorriente(String dni, String nombre, double saldo) { //constructor
        this.dni = dni; //dni pasado como parámetro
        this.nombre = nombre; //nombre pasado como parámetro
        this.saldo = saldo; //inicializamos el saldo por defecto
    }
    
    CuentaCorriente(String dni, double saldo){
        this.dni=dni;
        this.saldo=saldo;
    }
    Gestor gestor;
    public CuentaCorriente(String dni, String nombre, Gestor gestor){
        this.dni=dni;
        this.nombre=nombre;
        this.gestor=gestor;
    }
    CuentaCorriente(String dni, String nombre){
        this.dni=dni;
        this.nombre=nombre;
        this.saldo=0.0;
    }

    public CuentaCorriente(String dni, double saldo, Gestor gestor) {
        this.dni = dni;
        this.saldo = saldo;
        this.gestor = gestor;
    }


    boolean egreso(double cant) { //sacar dinero de la cuenta corriente
        boolean operacionPosible;
        if (saldo >= cant) { //si disponemos de saldo suficiente
            saldo -= cant;
            operacionPosible = true;
        } else { //no hay saldo disponible
            System.out.println("No hay dinero suficiente");
            operacionPosible = false;
        }
        return operacionPosible; //indica si ha sido posible realizar la operación
    }

    void ingreso(double cant) { //añadimos dinero a la cuenta corriente
        saldo += cant;
    }

    void mostrarInformacion() { //muestra el estado de la cuenta corriente
        System.out.println("Nombre: " + nombre);
        System.out.println("Dni: " + dni);
        System.out.println("Saldo: " + saldo + " euros");
    }
}
//Creamos un objeto CuentaCorriente para probar la clase y realizar algunas operaciones.
    class Tema7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe tu dni");
        String dni=sc.nextLine();
        System.out.println("Escribe tu nombre");
        String nombre=sc.nextLine();
        System.out.println("escribe si quieres poner saldo");
        double saldo=sc.nextDouble();
        CuentaCorriente c = new CuentaCorriente(dni,nombre,saldo); 
        

    }
}

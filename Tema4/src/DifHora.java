import java.util.Scanner;

public class DifHora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe una hora");
        int hora = sc.nextInt();
        int minuto = sc.nextInt();
        System.out.println("Escribe una segunda hora para ver la diferencía de las mismas.");
        int hora2 = sc.nextInt();
        int minuto2 = sc.nextInt();
        if ((hora >24 || hora2 > 24 || minuto > 60 || minuto2 > 60)) {
            System.out.println("No es valido");
        }
        System.out.println(difHoraria(hora,minuto,hora2,minuto2));
    }
    static int difHoraria(int hora, int minuto,int hora2, int minuto2) {
        int difHora = hora > hora2 ? hora - hora2 : hora2 - hora;
        int difMinuto = minuto > minuto2 ? minuto - minuto2 : minuto2 - minuto;
        if (difHora > 0) {
            return (60*difHora) + difMinuto;
        }else{
            return difMinuto;
        }

    }
}

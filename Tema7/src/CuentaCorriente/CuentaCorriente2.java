package CuentaCorriente;


public class CuentaCorriente2 {
    public static void main(String[] args) {
        CuentaCorriente c;
        c = new CuentaCorriente("12345678-A","Pepe");
        c.saldo =2000;
        c.dni="11111111-T";
        c.nombre = "Antonio";
        CuentaCorriente c1,c2;
        c1 = new CuentaCorriente("12345678-A","Pepe");
        c2= new CuentaCorriente("999999999-E","Ana");
        c1.mostrarInformacion();
        CuentaCorriente.setBanco("banco Central");
        c1.mostrarInformacion();
        CuentaCorriente.setBanco("Caja de ahorros de do-While");
        c1.mostrarInformacion();
        c2.mostrarInformacion();
    }
}

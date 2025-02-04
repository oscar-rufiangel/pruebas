
package Tienda;

public class Tienda {
    private String direccion;
    private int Chicle;
    private int CocaCola;
    private int Donut;
    static int totalChicle;
    static int totalCocaCola;
    static int totalDonut;

    public Tienda(String direccion, int chicle, int CocaCola, int Donut) {
        this.direccion = direccion;
        this.Chicle = chicle;
        this.CocaCola = CocaCola;
        this.Donut = Donut;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public void setChicle(int chicle) {
        this.Chicle = chicle;
    }

    public void setCocaCola(int CocaCola) {
        this.CocaCola = CocaCola;
    }

    public void setDonut(int Donut) {
        this.Donut = Donut;
    }
    
    void comprarChicle(int cantidad){
        Chicle+=cantidad;
        totalChicle+=cantidad;
    }
    
    void comprarCocaCola(int cantidad){
        CocaCola+=cantidad;
        totalCocaCola+=cantidad;
    }
    
    void comprarDonut(int cantidad){
        Donut+=cantidad;
        totalDonut+=cantidad;
    }
    
    void consultarVentasParciales(){
        System.out.println("En la tienda " + direccion + " las ventas son: "
        +"\n Chicles="+Chicle
        +"\n CocaColas= "+ CocaCola
        +"\n Donut= " + Donut);
        
    }

    
    public String toString(){
        return"En todas las tiendas las ventas son: "
        +"\n Chicles="+totalChicle
        +"\n CocaColas= "+ totalCocaCola
        +"\n Donut= " + totalDonut;
        
    }
}

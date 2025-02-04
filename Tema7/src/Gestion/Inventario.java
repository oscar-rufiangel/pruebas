package Gestion;

//@author oscar
import java.util.Arrays;

public class Inventario {

    Productos[] inventario;
    int max;

    public Inventario(int num) {
        this.inventario = new Productos[0];
        max = num;
    }

    void añadirProducto(Productos a) {
        
        if(inventario.length<max){
        Productos[] temp =Arrays.copyOf(inventario, inventario.length + 1);
        Productos producto = a;
        System.arraycopy(temp, 0, temp, 0, inventario.length + 1);
        temp[inventario.length] = a;
        inventario = temp;
        }else{
            System.out.println("Error, no se puede añadir un producto");
        }
    }

    Productos detallesProducto(int id) {
        int indice = buscarProducto(id);
        if (indice > -1) {
            return inventario[indice];
        }
        return null;
    }

    int buscarProducto(int id) {
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i].getId() == id) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

    void eliminarProducto(int id) {
        int borrar = buscarProducto(id);
        if (borrar == Integer.MAX_VALUE) {
            System.out.println("id no valido");
            return;
        }
        System.arraycopy(inventario, borrar + 1, inventario, borrar, inventario.length - borrar - 1);

        inventario = Arrays.copyOf(inventario, inventario.length - 1);
    }

    @Override
    public String toString(){
        return ""+Arrays.toString(inventario).replace("[", "").replace("]", "").replace(",", "");
    }

}

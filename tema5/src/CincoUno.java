public class CincoUno {
    public static void main(String[] args) {
        int numeros[];
        int suma=0;
        numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random()*100+1);
            System.out.println(numeros[i]);
        }
        for (int numero = 0;numero<numeros.length;numero++ ){
            suma +=numeros[numero];
        }
        System.out.println(suma);
    }
    
}

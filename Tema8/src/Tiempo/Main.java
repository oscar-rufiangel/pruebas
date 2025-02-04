
package Tiempo;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        HoraExacta c= new HoraExacta(0, 0, 0);
        c.inc();
        System.out.println(c);
        for (int i = 0; i < 86400; i++) {
            try {
                Thread.sleep(10);

            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            
            System.out.println(c);
        }
    }
}

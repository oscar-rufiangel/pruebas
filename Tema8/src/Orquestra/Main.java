
package Orquestra;

public class Main {
    public static void main(String[] args) {
        Piano p = new Piano();
        Campana c= new Campana();
        p.add(Nota.DO);
        c.add(Nota.DO);
        p.add(Nota.RE);
        c.add(Nota.RE);
        p.add(Nota.MI);
        c.add(Nota.MI);
        p.add(Nota.FA);
        c.add(Nota.FA);
        p.add(Nota.SOL);
        c.add(Nota.SOL);
        p.add(Nota.LA);
        c.add(Nota.SI);
        c.interpretar();
        p.interpretar();
        
    }
}


package Orquestra;



public class Campana extends Instrumento{
    public Campana() {
        super();
    }

    @Override
    public void interpretar() {
        for (Nota nota : melodia) {
            switch (nota) {
                case DO->System.out.println("doolooo");
                case RE->System.out.println("reeleee");
                case MI->System.out.println("miiliii");
                case FA->System.out.println("faalaaa");
                case SOL->System.out.println("sooloool");
                case LA->System.out.println("laalaaa");
                case SI->System.out.println("siiliii");
            }
        }
    }
}

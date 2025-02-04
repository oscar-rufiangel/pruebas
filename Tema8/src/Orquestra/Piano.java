package Orquestra;



public class Piano extends Instrumento {

    public Piano() {
        super();
    }

    @Override
    public void interpretar() {
        for (Nota nota : melodia) {
            switch (nota) {
                case DO->System.out.println("dooooo");
                case RE->System.out.println("reeeee");
                case MI->System.out.println("miiiii");
                case FA->System.out.println("faaaaa");
                case SOL->System.out.println("soooool");
                case LA->System.out.println("laaaaa");
                case SI->System.out.println("siiiii");
            }
        }
    }

}

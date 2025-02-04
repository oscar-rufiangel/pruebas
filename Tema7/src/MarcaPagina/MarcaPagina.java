package MarcaPagina;

public class MarcaPagina {
    private String libro;
    private int pagina;
    
    String getLibro(){
        return libro;
    }
    void setLibro(String nuevoLibro){
        this.libro=nuevoLibro;
        this.pagina=0;
    }
    void incrementarPaginaLibro(){
        pagina++;
    }
    void MostrarInformacion(){
        System.out.println("Libro: "+libro+".");
        System.out.println("Pagina: "+pagina+".");
    }
}

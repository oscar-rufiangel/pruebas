package Hora;

public class Hora {
    private byte hora;     // Atributo que almacena la hora
    private byte minuto;   // Atributo que almacena los minutos
    private byte segundo;  // Atributo que almacena los segundos

    // Método getter para obtener la hora
    public int getHora(){
        return hora;
    }

    // Método setter para establecer la hora
    public void setHora(int hora){
        if (hora < 0 || hora > 23) {  // Verifica si la hora es válida
            this.hora = (byte)0;      // Si no es válida, se establece en 0
        }
        this.hora = (byte)hora;       // Asigna la hora
    }

    // Método getter para obtener los minutos
    public int getMinuto(){
        return minuto;
    }

    // Método setter para establecer los minutos
    public void setMinuto(int minuto){
        if(minuto < 0 || minuto > 59) {  // Verifica si los minutos son válidos
            this.minuto = (byte)0;       // Si no son válidos, se establecen en 0
        }
        this.minuto = (byte)minuto;      // Asigna los minutos
    }

    // Método getter para obtener los segundos
    public int getSegundo(){
        return segundo;
    }

    // Método setter para establecer los segundos
    public void setSegundo(int segundo){
        if(segundo < 0 || segundo > 59) {  // Verifica si los segundos son válidos
            this.segundo = (byte)0;        // Si no son válidos, se establecen en 0
        }
        this.segundo = (byte)segundo;      // Asigna los segundos
    }

    // Método para incrementar los segundos
    public void incrementaSegundo(){
        segundo++;
        if(segundo > 59){          // Si los segundos superan 59, se reinician a 0 y se incrementa un minuto
            segundo = 0;
            minuto++;
        }
        incrementaMinuto();        // Incrementa los minutos si es necesario
    }

    // Método para incrementar los minutos
    public void incrementaMinuto(){
        if(minuto > 59){           // Si los minutos superan 59, se reinician a 0 y se incrementa una hora
            minuto = 0;
            hora++;
        }
        incrementaHora();          // Incrementa las horas si es necesario
    }

    // Método para incrementar las horas
    public void incrementaHora(){
        if(hora > 23){             // Si las horas superan 23, se reinician a 0
            hora = 0;
        }
    }
}

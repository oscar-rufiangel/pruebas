package Ecuacion2Grado;

import java.util.Arrays;

public class Ecuacion2Grado {
    private double a;
    private double b;
    private double c;

    public Ecuacion2Grado(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }
    
    boolean espositivoDiscriminante(){
        return discriminante()>=0;
    }
    
    double discriminante(){
        return Math.pow(b, 2)-4*a*c;
    }
    
    double[] solucion(){
        double[] solucion=new double[2];
        if(espositivoDiscriminante()){
            solucion[0]=(- b + Math.sqrt(discriminante())) / 2 * a;
            solucion[1]=(- b - Math.sqrt(discriminante())) / 2 * a;

        }else{
            solucion[0]=Double.NaN;
            solucion[1]=Double.NaN;

        }
        return solucion;
    }
    void mostrarSolucion(){
        System.out.println(Arrays.toString(solucion()));
    }
    
}

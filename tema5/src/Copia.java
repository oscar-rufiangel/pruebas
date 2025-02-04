import java.util.Arrays;
public class Copia {
    public static void main(String[] args) {
        int src[]={1,2,3};
        int copia[]= new int[src.length];
        copia=copiaArrays(src,copia);
        System.out.println(Arrays.toString(copia));
    }
    static int [] copiaArrays(int[] src,int[] dest){
        
        for (int i=0;i<dest.length;i++){
            dest[i]=src[i];
        }
            return dest;
    }
}

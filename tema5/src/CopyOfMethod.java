
import java.util.Arrays;


public class CopyOfMethod {
    public static void main(String[] args) {
        int [] original= {1,2,3,4,5,6,7,8,9};
        int nuevaLong=5;
        int [] copia =copyOf(original,nuevaLong);
        System.out.println(Arrays.toString(copia));
    }
    static int [] copyOf(int[]original,int nuevaLong){
        int [] temp= new int[nuevaLong];
        for(int i=0; i < Math.min(original.length,nuevaLong);i++){
            temp[i]=original[i];
        }
        return temp;
    }
}

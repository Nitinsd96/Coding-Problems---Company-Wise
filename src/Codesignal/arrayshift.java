package Codesignal;
import java.util.*;
public class arrayshift {
    public static void main(String[] args) {
        System.out.println(arrayshift(new int[]{4,5,1,2,3}));
    }
    public static boolean arrayshift(int[] array1){
        int[] arr = new int[array1.length];
        for(int i=0;i<array1.length;i++){
            arr[i]=i+1;
        }
        String one = Arrays.toString(array1);
        String two = Arrays.toString(arr);
        String three = one+one;
        System.out.println(one + ""+ two+""+three);

        return three.contains(two);


    }
}

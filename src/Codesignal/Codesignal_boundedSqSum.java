package Codesignal;

import java.util.*;

public class Codesignal_boundedSqSum {
    public static void main(String[] args) {
        int a[] = {3,-1,9};
        int b[] = {100,5,-2};
        int a1[] = {1,2,3,-1,-2,-3};
        int b1[] = {10};
        Codesignal_boundedSqSum obj = new Codesignal_boundedSqSum();
        System.out.println(obj.boundedSum(a,b,7,99));
        System.out.println(obj.boundedSum(a1,b1,0,100));

    }
    public int boundedSum(int[] a,int[] b,int lower, int upper){
        int count = 0;
        Arrays.sort(a);Arrays.sort(b);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                int sum = a[i]*a[i] + b[j]*b[j];
                if(lower<=sum && sum<=upper){
                    count++;
                }
                if(sum>upper)
                    break;
            }
        }
        return count;
    }
}

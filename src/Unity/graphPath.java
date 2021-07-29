package Unity;

import java.util.*;

public class graphPath {
    public static void main(String[] args) {
        graphPath obj = new graphPath();
        List<Integer> ll = new ArrayList<Integer>();
        ll.add(1);
        ll.set(0,5);
        ll.set(1,2);
        System.out.println(ll);
        int[] A = {1,2,4,4,3};
        int[] B = {2,3,1,3,1};
        //System.out.println(obj.traverse(A,B,4,1));

        int[] A1 = {1,2,1,3};
        int[] B1 = {2,4,3,4};
        //System.out.println(obj.traverse(A1,B1,4,1));

        int[] A2 = {2,4,5,3};
        int[] B2 = {3,5,6,4};
        //System.out.println(obj.traverse(A2,B2,6,1));

        int[] A3 = {1,3};
        int[] B3 = {2,2};
        //System.out.println(obj.traverse(A3,B3,3,1));
    }
    public boolean traverse(int[] A,int[] B, int N, int number){
        if(number == N)
            return true;
        for(int i=0;i<A.length;i++){
            if(A[i]==number && B[i]==number+1 || A[i]==number+1 && B[i]==number){
                if(traverse(A,B,N,number+1))
                    return true;
            }
        }
        return false;
    }
}

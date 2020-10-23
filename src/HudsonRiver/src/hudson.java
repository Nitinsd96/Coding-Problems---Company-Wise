package HudsonRiver.src;

import java.util.*;
public class hudson {
    public static void main(String[] args) {
        int[] arr = {2,3,3,2,2,2,1};
        int[] arr1 = {1,2};
        int[] arr2 = {2,5,3,2,4,1};
        hudson obj = new hudson();
        System.out.println(obj.solution(arr));
        System.out.println(obj.solution(arr1));
        System.out.println(obj.solution(arr2));
    }
    public int solution(int[] arr){
        Arrays.sort(arr);
        Stack<Integer> st = new Stack();
        int temp = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>temp ){
                temp = arr[i];
                count++;
            }
            else{
                if(st.isEmpty()){
                    st.add(arr[i]);
                    continue;
                }
                if(st.peek()!=arr[i])
                    st.add(arr[i]);
            }
        }
        if(!st.isEmpty() && st.peek()==temp)
            st.pop();
        return st.size()+count;
    }
}

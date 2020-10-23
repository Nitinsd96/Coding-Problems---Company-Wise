package DRW.src;

import java.util.*;

public class adjVal {
    public static void main(String[] args) {
        int[] arr = {0,3,3,7,5,3,11,1};
        //b cint[] arr = {1,4,7,3,3,5};
        adjVal obj = new adjVal();
        System.out.println(obj.findAbs(arr));
    }
    public int findAbs(int[] arr){
        int out = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer,Integer> left = new HashMap();
        Map<Integer,Integer> right = new HashMap();

        for(int i=0;i<arr.length;i++){
            if(!pq.contains(arr[i]))
                pq.add(arr[i]);
            if(!left.containsKey(arr[i]))
                left.put(arr[i],i);
            right.put(arr[i],i);
        }
        while(pq.size()!=1){
            int temp = pq.poll();
            out = Math.min(out,Math.min(Math.abs(left.get(temp)-right.get(pq.peek())),Math.abs(right.get(temp)-left.get(pq.peek()))));
        }
        return out;
    }
}

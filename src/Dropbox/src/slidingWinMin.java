package Dropbox.src;

import java.util.*;

public class slidingWinMin {
    public static void main(String[] args) {
        slidingWinMin obj = new slidingWinMin();
        int[] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(obj.minSlidingWindow(arr,3)));;
    }
    public int[] minSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList();
        int[] output = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            if(dq.isEmpty()){
                dq.addLast(i);
            }
            else{
                if(nums[i]>nums[dq.peekFirst()]){
                    if(dq.size()==k)
                        dq.removeLast();
                    dq.addFirst(i);
                }
                else{
                    while(!dq.isEmpty() && nums[dq.peekFirst()]>nums[i] ){
                        dq.pollFirst();
                    }
                    dq.addFirst(i);
                }
            }
            if(dq.peekLast()<=i-k)
                dq.removeLast();
            if(i>=k-1)
                output[i-k+1] = nums[dq.peekLast()];
        }
        return output;
    }

}

package Citrix;
import java.util.*;
public class calculate_region {
    public static void main(String[] args) {
        int[] h1 = {1, 2, 1};
        int[] h2 = {1, 1, 1, 1};
        calculate_region obj = new calculate_region();
        int[] r1 = obj.max_array(h2);
        //int[] r2 = obj.max_array(h1);
        //System.out.println(Arrays.toString(r1));
        //System.out.println(Arrays.toString(r2));
        //System.out.println(obj.max_array(h2));
    }

    /* public int max_array(int[] heights){
         int result = 0;
         for(int i=0;i<heights.length;i++){
             int count = 0;
             for(int j=i;j>=0;j--){
                 if(heights[j]>heights[i]){
                     break;
                 }
                 count++;
             }
             for(int j=i;j<heights.length;j++){
                 if(heights[j]>heights[i]){
                     break;
                 }
                 count++;
             }
             result = result + count - 1;
         }
         return result;
     }
 */
    public int[] max_array(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i =nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.empty() ? nums.length : stack.peek();
            stack.push(i );

        }
        System.out.println(Arrays.toString(res));

        int[] res2 = new int[nums.length];
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < nums.length; ++i) {
            while (!stack2.empty() && nums[stack2.peek()] <= nums[i]) {
                stack2.pop();
            }
            res2[i] = stack2.empty() ? -1 : stack2.peek();
            stack2.push(i);

        }
        System.out.println(Arrays.toString(res2));
        int result= 0;
        for(int i=0;i<res.length;i++){
            result = result + (res[i]-1 - res2[i]-1)+1;
        }
        System.out.println(result);
        return res;
    }
}


import java.util.*;

public class roblox {
    public static void main(String[] args) {
        int arr[] = new int[]{100,50,50,25};
        int arr2[] = new int[]{20,40,60,80,100};
        int arr3[] = new int[]{2,2,3,4,5};
        roblox obj = new roblox();
        System.out.println(obj.smallerNumbersThanCurrent(arr,3));
        System.out.println(obj.smallerNumbersThanCurrent(arr2,4));
        System.out.println(obj.smallerNumbersThanCurrent(arr3,4));
    }
    public int smallerNumbersThanCurrent(int[] nums,int k) {
        int[] out = new int[nums.length];
        int[] rank = new int[101];
        int count = 0;
        for(int i=0;i<nums.length;i++){
            rank[nums[i]]++;
        }
        for(int i=1;i<101;i++){
            rank[i] = rank[i]+rank[i-1];
        }
        //System.out.println(Arrays.toString(rank));
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                out[i]=0;
            else
                out[i]= rank[100]-rank[nums[i]]+1;
        }
        System.out.println(Arrays.toString(out));
        for(int i=0;i<out.length;i++){
            if(out[i]<=k)
                count++;
        }
//        System.out.println(Arrays.toString(out));
        return count;
    }
}

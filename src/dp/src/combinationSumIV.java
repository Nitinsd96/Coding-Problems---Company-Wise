package dp.src;

import java.util.Arrays;

public class combinationSumIV {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        combinationSumIV obj = new combinationSumIV();
        System.out.println(obj.combinationIV(nums,4));
    }
    public int combinationIV(int[] nums, int target){
        int[][] dp = new int[nums.length][target+1];
        //Arrays.fill(dp,-1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=target;j++){
                dp[i][j] = -1;
            }
        }
        return combine(nums,target,0,dp);
    }
    public int combine(int[] nums,int target,int index,int[][] dp){
        if(target == 0)
            return 1;
        if(index>=nums.length)
            return 0;
        if(dp[index][target]==-1){
            int sum1 = 0;
            if(nums[index]<=target){
                sum1 = combine(nums,target-nums[index],index,dp);
            }
            int sum2 = combine(nums,target,index+1,dp);
            dp[index][target]=sum1+sum2;
            //return dp[index][target];
        }
        return dp[index][target];
    }
}

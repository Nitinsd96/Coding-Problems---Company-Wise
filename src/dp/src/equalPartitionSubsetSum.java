package dp.src;

public class equalPartitionSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100};
        equalPartitionSubsetSum obj = new equalPartitionSubsetSum();
        System.out.println(obj.partition(nums));
    }
    public boolean partition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            //System.out.println(sum);
        }
        if (sum % 2 != 0)
            return false;
        int[][] dp = new int[nums.length][sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < sum / 2 + 1; j++)
                dp[i][j] = -1;
        }
        if (check(dp, nums, sum / 2, 0) == 1)
            return true;
        return false;
    }

    public int check(int[][] dp,int[] array, int sum,int current){
        System.out.println("sum" + sum + "current" + current);
        if(sum==0)
            return 1;
        if(current>=array.length || array.length == 0)
            return 0;
        if(dp[current][sum]==-1){
            if(array[current]<=sum){
                if(check(dp,array,sum-array[current],current+1)==1){
                    dp[current][sum] = 1;
                    return 1;
                }
            }
                dp[current][sum] = check(dp,array,sum,current+1);
        }
        return dp[current][sum];
    }
}

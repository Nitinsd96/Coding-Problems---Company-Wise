package DRW.src;

import java.util.Arrays;

public class minPairSum {
    public static void main(String[] args) {
        //int[] arr = {5,3,1,2,8,10};
        int[] arr = {5,2,4,6,3,7,1,4,65,23,1};
        int[][] dp = new int[arr.length][2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                dp[i][j]=-1;
        }
        minPairSum obj = new minPairSum();
        System.out.println(obj.combination(arr,0,1,dp));
    }
    public int combination(int[] arr,int count,int index,int[][] dp){
        if(count==2 )
            return 0;
        if(index > arr.length-2)
            return Integer.MAX_VALUE;
        if(dp[index][count]==-1 ){
            int sum1 =  combination(arr,count+1,index+2,dp);
            if(sum1!=Integer.MAX_VALUE){
                sum1 = sum1 + arr[index];
            }
            int sum2 =  combination(arr,count,index+1,dp);
            //System.out.println(Math.min(sum1,sum2) );
            dp[index][count] = Math.min(sum1,sum2);
        }
        //System.out.println(Arrays.toString(dp));
        return dp[index][count];
    }
}

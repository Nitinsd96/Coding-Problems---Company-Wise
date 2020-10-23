package dp.src;

public class coinChange {
    public static void main(String[] args) {
        int[] coin = new int[]{1,2,5};
        coinChange obj = new coinChange();
        System.out.println(obj.coinChange(coin,11));
    }
    public int coinChange(int[] coin, int target){
        int[][] dp= new int[coin.length][target+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return combination(coin,target,0,0,dp);
    }
    public int combination(int[] coin,int target,int index,int coinCount,int[][] dp){
        if(target==0)
            return 0;
        if(index>=coin.length)
            return Integer.MAX_VALUE;
        if(dp[index][target]==-1){
            int count1=Integer.MAX_VALUE;
            if(coin[index] <= target){
                int temp = combination(coin,target-coin[index],index,coinCount+1,dp);
                if(temp != Integer.MAX_VALUE){
                    count1 = 1 + temp;
                }
            }
            int count2 = combination(coin,target,index+1,coinCount,dp);
//            if(count1 == 0 || count2 == 0){
//        //        return count1+count2;
//                 dp[index][target]=count1+count2;
//                 return dp[index][target];
//            }
          //  return Math.min(count1,count2);
             dp[index][target]=Math.min(count1,count2);
        }
        System.out.println("index   "+ index + "target::" + target);
        return dp[index][target];
    }
}

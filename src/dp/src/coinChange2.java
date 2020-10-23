package dp.src;

public class coinChange2 {
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        coinChange2 obj = new coinChange2();
        System.out.println(obj.change(5,coins));
    }
    public int change(int amount,int[] coins){
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return coinCombination(amount,coins,0,dp);
    }
    public int coinCombination(int amount,int[] coins,int index,int[][] dp){
        if(amount == 0)
            return 1;
        if(index==coins.length)
            return 0;
        if(dp[index][amount] == -1){
            int count1 = 0;
            if(coins[index]<=amount){
                count1 = coinCombination(amount-coins[index],coins,index,dp);
            }
            int count2 = coinCombination(amount,coins,index+1,dp);
            //return count1+count2;
             dp[index][amount] = count1+count2;
        }
        return dp[index][amount];
    }
}





//
//------------------------BACKTRACK SOLUTION---------------------
//        int count = 0;
//public int change(int amount, int[] coins) {
//        combinatio(amount, coins, 0);
//        return count;
//        }
//public void combinatio(int amount,int[] coins, int index){
//        System.out.println(amount+"    "+index);
//        if(amount==0){
//        count++;
//        return;
//        }
//        for(int i=index;i<coins.length;i++){
//        if(coins[i]<=amount) {
//        combinatio(amount-coins[i],coins,i);
//        }
//        }
//        return;
//        }
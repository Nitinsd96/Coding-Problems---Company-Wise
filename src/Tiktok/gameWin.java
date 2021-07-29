package Tiktok;

public class gameWin {
        public static void main(String[] args){
            gameWin pbj = new gameWin();
            System.out.println(pbj.game(2,1,3));


            System.out.println(pbj.game(10,5,2));


            System.out.println(pbj.game(3,1,6));
        }
        public double game(int n,int m, int k){
            int[] nums = new int[m+1];
            for(int i=0;i<=m;i++)
                nums[i]=i;
//            int[][] dp = new int[nums.length][n+1];
//            //Arrays.fill(dp,-1);
//            for(int i=0;i<nums.length;i++){
//                for(int j=0;j<=n;j++){
//                    dp[i][j] = -1;
//                }
//            }
            int s = combine(nums,n,0,k);
            double total = Math.pow(nums.length,k);
            System.out.println(total);
            return s/total;
        }
    public int combine(int[] nums,int target,int index,int k){
        System.out.println(target+"    "+ index+"  "+k);
        if(target <= 0)
            return (int)Math.pow(nums.length,k);
        if(index>=nums.length || k==0)
            return 0;
       // if(dp[index][target]==-1){
            int sum1 = combine(nums,target-nums[index],0,k-1);
            int sum2 = combine(nums,target,index+1,k);
           // dp[index][target]=sum1+sum2;
            return sum1+sum2;
       // }
       // return dp[index][target];
        }
}

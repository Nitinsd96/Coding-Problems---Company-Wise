package dp.src;

import java.util.*;

public class reachingPoints {
    public static void main(String[] args) {
        reachingPoints obj = new reachingPoints();
        obj.reachingPoints(35,13,455955547,420098884);
    }
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
             int[][] dp = new int[tx+1][ty+1];

             for(int i=0;i<dp.length;i++){
                 for(int j=0;j<dp[0].length;j++)
                     dp[i][j] = -1;
             }
           // Map<String,Integer> hash = new HashMap();

            boolean out = travel(sx,sy,tx,ty,dp)==1 ? true : false ;
             System.out.println(out);
            return out ;
        }
        public int travel(int sx,int sy, int tx, int ty,int[][] dp){
            if(sx==tx && sy == ty)
                return 1;
            if(dp[sx][sy]==-1){
                if((sx+sy)<=ty && travel(sx,sx+sy,tx,ty,dp)==1)
                    return dp[sx][sy]=1;
                if((sx+sy)<=tx && travel(sx+sy,sy,tx,ty,dp)==1)
                    return dp[sx][sy]=1;
                dp[sx][sy]=0;
                //hash.put(sx+""+sy,0);
            }
            return dp[sx][sy];
            //return hash.get(sx+""+sy);
        }
}

package Codesignal;

public class movingDiagonal {
    public static void main(String[] args) {
        movingDiagonal obj = new movingDiagonal();
        System.out.println(obj.movingDiagonal(5,5,2,1,1,2));
    }
    public int movingDiagonal(int n,int m, int x1, int y1, int x2, int y2){
        return ways(n,m,x1,y1,x2,y2,new boolean[n][m]);

    }
    public int ways(int n,int m, int x1, int y1, int x2, int y2,boolean[][] visited){

        if(x1==x2 && y1==y2)
            return 0;
        if(x1<0 || x1>=n || y1<0 || y1>=m )
            return Integer.MAX_VALUE;
        System.out.println(x1+" "+y1);
        if(visited[x1][y1])
            return Integer.MAX_VALUE;
        visited[x1][y1]=true;
        int count1 = ways(n,m,x1+1,y1+1,x2, y2,visited);
        if(count1!=Integer.MAX_VALUE)
            count1=1+count1;
        int count2 = ways(n,m,x1+1,y1-1,x2, y2,visited);
        if(count2!=Integer.MAX_VALUE)
            count2=1+count2;
        int count3 = ways(n,m,x1-1,y1+1,x2, y2,visited);
        if(count3!=Integer.MAX_VALUE)
            count3=2+count3;
        int count4 = ways(n,m,x1+1,y1-1,x2, y2,visited);
        if(count4!=Integer.MAX_VALUE)
            count4=2+count4;
       // visited[x1][y1]=false;
        return Math.min(count1,Math.min(count2,Math.min(count3,count4)));
    }
}

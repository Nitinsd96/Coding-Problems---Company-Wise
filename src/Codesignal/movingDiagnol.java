//package Codesignal;
//
//public class movingDiagnol {
//    int count=0;
//    public static void main(String[] args) {
//        stepsToReachinAGrid obj = new stepsToReachinAGrid();
//        System.out.println(obj.movingDiagonal(5,5,2,1,1,2));
//    }
//    public int movingDiagonal(int n,int m, int x1, int y1, int x2, int y2){
//        return ways(n,m,x1,y1,x2,y2,new boolean[n][m]);
//
//    }
//    public boolean ways(int n,int m, int x1, int y1, int x2, int y2,boolean[][] visited){
//        if(x1<0 || x1>=n || y1<0 || y1>=m){
//            count++;
//            return false;
//        }
//
//        if(x1==x2 && y1==y2)
//            return true;
//        visited[x1][y1]=true;
//        count++;
//        if(ways(n,m,x1+1,y1+1,x2, y2,visited))
//            return true;
//        if(ways(n,m,x1+1,y1-1,x2, y2,visited))
//            return true;
//        if(ways(n,m,x1-1,y1+1,x2, y2,visited))
//            return true;
//        if(ways(n,m,x1-1,y1-1,x2, y2,visited))
//            return true;
//        visited[x1][y1]=true;
//    }
//}

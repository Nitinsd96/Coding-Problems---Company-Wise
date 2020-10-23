package Dropbox.src;

public class dropbox {
        boolean[] visited ;
        int count = 0;
    public static void main(String[] args) {
        dropbox obj = new dropbox();
        int[][] matrix = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(obj.findCircleNum(matrix));
    }
    public int findCircleNum(int[][] M) {
            visited = new boolean[M.length];
            int out = 0;
            for(int i=0;i<M.length;i++){
                for(int j=0;j<M[0].length;j++){
                    count = 0;
                    if(!visited[i] && M[i][j]==1){
                        traverse(i,M);
                        out = Math.max(out,count);
                    }
                }
            }
            return out;
    }
    public void traverse(int i,int[][] M){
            visited[i] = true;
            count++;
            for(int j=0;j<M[0].length;j++){
                if(M[i][j]==1 && !visited[j]){
                    traverse(j,M);
                }
            }
    }
}

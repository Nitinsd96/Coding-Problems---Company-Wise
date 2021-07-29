package NITJ;

import java.util.Arrays;

public class foodfest {
    public static void main(String[] args) {
        int[] arr = {1,9,2,3,0,6,7,8};
        foodfest obj = new foodfest();
        obj.subseqMultply(arr);
    }
    public int subseqMultply(int[] arr){
        int[][] matrixmult = new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(j>=i)
                    matrixmult[i][j] = arr[i]*arr[j];
            }
        }
        int result = 0;
       for(int start=arr.length-1;start>=0;start--){
            int row = 0; int col = start;
            int[] maxend = new int[matrixmult.length];
            int k = 0;
            maxend[k++]=matrixmult[row++][col--];
            for(col=start-1;col>=row;col--){
                maxend[k]=Math.max(maxend[k-1]+matrixmult[row][col],matrixmult[row][col]);
                row++;
                k++;
            }
            for(int i=0;i<maxend.length;i++) {
                result = Math.max(result, maxend[i]);
            }
        }

        for(int start=0;start<matrixmult.length;start++){
            int row = start; int col = matrixmult.length-1;
            int[] maxend = new int[matrixmult.length];
            int k = 0;
            maxend[k++]=matrixmult[row++][col];
            for(col=col-1;col>=row;col--){
                maxend[k]=Math.max(maxend[k-1]+matrixmult[row][col],matrixmult[row][col]);
                row++;
                k++;
            }
            for(int i=0;i<maxend.length;i++){
                result = Math.max(result,maxend[i]);
            }

        }
       System.out.println(result);
       return result;
    }
}

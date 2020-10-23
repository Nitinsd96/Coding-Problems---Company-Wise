package Citedal.src;

import java.util.*;

public class matrixSummation {
    public static void main(String[] args) {
        int[][] matrix = {{3,5,6},{7,14,22},{15,25,35}};
        matrixSummation obj = new matrixSummation();
        int[][] out = obj.compute(matrix);
        for(int i=0;i<out.length;i++)
            System.out.println(Arrays.toString(out[i]));
    }
    public int[][] compute(int[][] matrix) {
        int[][] out = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0 && j== 0) out[i][j] = matrix[i][j];
                else if(i==0)
                    out[i][j] = matrix[i][j] - matrix[i][j-1];
                else if(j==0)
                    out[i][j] = matrix[i][j] - matrix[i-1][j];
                else
                    out[i][j] = matrix[i][j] - (matrix[i][j-1]+matrix[i-1][j]-matrix[i-1][j-1]);
            }
        }
        return out;
    }
}

package dp.src;

import java.util.*;

public class oddDecompose {
    static  List<Integer> out = new ArrayList();
    public static void main(String[] args) {
        int N = 11;
        oddDecompose obj = new oddDecompose();
        obj.decomposition(1,N,N,0);
        System.out.println(out);
    }
    public boolean decomposition(int idx,int N, int sum,int count){
        if(sum==0){
            return true;
        }
        for(int i=idx;i<=N;i++){
            if(i%2==1 && i<=sum){
                out.add(i);
                if(decomposition(i+2,N,sum-i,count+1))
                    return true;
                out.remove(out.size()-1);
            }
        }
        return false;
    }
}

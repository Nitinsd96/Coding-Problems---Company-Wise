package Citedal.src;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.Comparator;

public class Citedal {
    public static void main(String[] args) {
        //int[][] bids = {{1,2,5,0},{2,1,4,2},{3,5,4,6}};
        int[][] bids = {{1,5,5,0},{2,7,8,1},{3,7,5,1},{4,10,3,3}};
        int totalShares = 9;
        Citedal obj = new Citedal();
        int[] arr = obj.ipo(bids,totalShares);
        System.out.println(Arrays.toString(arr));
    }
    public int[] ipo(int[][] bids, int totalShares){
        Map<Integer,Integer> hash = new HashMap();
        for(int i=0;i<bids.length;i++){
            int price = bids[i][2];
            hash.put(price,hash.getOrDefault(price,0)+1);
        }
        Arrays.sort(bids, new mySort());
        for(int i=0;i<bids.length;i++)
            System.out.println(Arrays.toString(bids[i]));
        int i=0; int offset = 0;
        while(i< bids.length && totalShares > 0){
            int iterate = hash.get(bids[i][2]);
            int sum = 0;
            for(int j=0;j<iterate;j++){
                sum = sum + bids[i+j][1];
            }
            if(sum > totalShares && iterate > totalShares){
                offset = totalShares;
                break;
            }
            totalShares = totalShares - sum;
            i = i + iterate;
        }
        int idx = i + offset;
        int[] out = new int[bids.length-idx];
        for(int j=idx;j<bids.length;j++){
            out[j-idx] = bids[idx+(j-idx)][0];
        }
        return out;
    }
}
class mySort implements Comparator<int[]> {
    public int compare(int[] a,int[] b){
        if(a[2]==b[2]){
            return a[3]-b[3];
        }
        else
            return b[2]-a[2];
    }
}

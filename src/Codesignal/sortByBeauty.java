package Codesignal;

import java.util.*;

public class sortByBeauty {
    public static void main(String[] args) {
        int[][] arr = {{1,2,2,3},{3,4,10,4},{2,10,1,2},{5,4,4,5}};
        sortbybeauty(arr,2);
    }
    public static int[][] sortbybeauty(int[][] arr, int size){
        int[][] result = new int[arr.length][arr[0].length];
        HashMap<pair,Integer> hash = new HashMap();
        PriorityQueue<AbstractMap.SimpleEntry<pair,Integer>> pq = new PriorityQueue<>(new mysort());
        for(int i=0;i<arr.length;i=i+size){
            for(int j=0;j<arr[0].length;j=j+size){
                pair o = new pair();
                o.x =i; o.y = j;
                int b=beauty(i,j,size,arr);
                hash.put(o,b);
            }
        }
        for(Map.Entry<pair,Integer> entry : hash.entrySet()){
            AbstractMap.SimpleEntry<pair, Integer> abs = new AbstractMap.SimpleEntry(entry.getKey(),entry.getValue());
            pq.add(abs);
        }
        int o=0;int p=0;
        while(!pq.isEmpty()){
            AbstractMap.SimpleEntry<pair,Integer> x = pq.poll();
            pair key = x.getKey(); int a = key.x; int b = key.y;
            for(int i=a;i<a+size;i++){
                for(int j=b;j<b+size;j++){
                    result[o][p++] = arr[i][j];
                }
                o++;p=p-size;
            }
            p=p+size;
            if(p==arr[0].length){ p=0; }
            else if(o==arr.length){ o=o-size; }
            else{ o=o-size; }
        }
        for(int i=0;i<result.length;i++){
            System.out.println(Arrays.toString(result[i]));
        }
        return result;
    }
    public static int beauty(int x,int y, int size, int[][] arr){
        List<Integer> sets = new ArrayList();
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(!sets.contains(arr[i][j]))
                    sets.add(arr[i][j]);
            }
        }
        Collections.sort(sets);
        for(int i=0;i<sets.size();i++){
            if(sets.get(i)!=i+1){
                return i+1;
            }
        }
        return sets.size()+1;
    }
}
class pair {
    int x;
    int y;
    void pair(int x,int y){
        this.x = x;
        this.y=y;
    }
}
class mysort implements Comparator<Map.Entry<pair,Integer>>{
    public int compare(Map.Entry<pair,Integer> a, Map.Entry<pair,Integer> b){
        if(a.getValue()==b.getValue()){
            return a.getKey().x-b.getKey().x;
        }
        return a.getValue()-b.getValue();
    }
}
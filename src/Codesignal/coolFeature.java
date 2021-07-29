package Codesignal;

import java.util.*;

public class coolFeature {
    public static void main(String[] args) {
     coolFeature obj = new coolFeature();

     int[] a ={1,2,3};
     int[] b ={3,4};
     int[][] queries = {{1,5},{0,0,1},{1,5}};
     obj.coolfeature(a,b,queries); //ans=[2,1]

     int[] a1 ={1,2,2};
     int[] b1 ={2,3};
     int[][] queries1 = {{1,4},{0,0,3},{1,5}};
    obj.coolfeature(a1,b1,queries1); //ans=[3,4]
    }
    public int[] coolfeature(int[] a,int[] b,int[][] query){
        Map<Integer,Integer> hashofA = new HashMap<>();
        Map<Integer,Integer> hashofB = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<a.length;i++)
            hashofA.put(a[i],hashofA.getOrDefault(a[i],0)+1);
        for(int i=0;i<b.length;i++)
            hashofB.put(b[i],hashofB.getOrDefault(b[i],0)+1);
        for(int i=0;i<query.length;i++){
            int query_type = query[i][0];
            if(query_type==0){
                int index = query[i][1];
                hashofB.put(b[index],hashofB.get(b[index])-1);
                if(hashofB.get(b[index])==0)
                    hashofB.remove(b[query[i][1]]);
                b[index]=query[i][2];
                hashofB.put(query[i][2],hashofB.getOrDefault(query[i][2],0)+1);
            }
            else{
                int count = 0;
                int target = query[i][1];
                for(int key : hashofA.keySet()){
                    if(hashofB.containsKey(target-key)){
                        count = count + hashofA.get(key)*hashofB.get(target-key);
                    }
                }
                result.add(count);
            }
        }
        int[] res = new int[result.size()];
        for(int i=0;i<result.size();i++)
            res[i]=result.get(i);
        System.out.println(Arrays.toString(res));
        return res;
    }

}

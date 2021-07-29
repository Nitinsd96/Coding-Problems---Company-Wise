package Codesignal;

import java.util.*;

public class mean_groups {
    public static void main(String[] args) {
        int[][] a = {{2, 3, 4}, {5, 5}, {5},{3,3,3}};
        mean_groups obj = new mean_groups();
        obj.meanGroups(a);
    }

    int[][] meanGroups(int[][] a) {
        Map<Integer, List<Integer>> hash = new HashMap();
        List<List<Integer>> pq = new ArrayList<List<Integer>>();
        for (int i = 0; i < a.length; i++) {
            int mean = 0;
            int sum = 0;
            for (int j : a[i]) {
                sum = sum + j;
            }
            mean = sum / a[i].length;
            if (hash.containsKey(mean)) {
                List<Integer> temp = new ArrayList(hash.get(mean));
                temp.add(i);
                hash.put(mean, temp);
            } else {
                List<Integer> temp = new ArrayList();
                temp.add(i);
                hash.put(mean, temp);
            }
        }
        for (int i = 0; i < hash.size(); i++)
            pq.add(new ArrayList());
        for (Map.Entry<Integer, List<Integer>> entry : hash.entrySet()){
            pq.add(entry.getValue());
            System.out.println(pq.get(pq.size()-1));
    }
        Collections.sort(pq, new mySort());
        int[][] r = new int[pq.size()][];
        for (int i = 0; i < pq.size(); i++) {
            r[i] = new int[pq.get(i).size()];
            for (int j = 0; j < pq.get(i).size(); j++) {
                r[i][j] = pq.get(i).get(j);
            }
        }
        return r;
    }
}
class mySort implements Comparator<List<Integer>>{
    public int compare(List<Integer> a,List<Integer> b){
            return a.get(0)-b.get(0);
        }
}



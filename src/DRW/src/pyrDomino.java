package DRW.src;

import java.util.*;

public class pyrDomino {
    public static void main(String[] args) {
        int[] array = {4,3,3,4,1,2,2,3,6,5,4,5};
        pyrDomino obj = new pyrDomino();
        System.out.println(obj.domino(array,0, new ArrayList(),new boolean[12]));
    }
    public boolean domino(int[] dom,int idx,List<Integer> lists, boolean[] visited){
        if(lists.size() == 12 && (lists.get(7)!=lists.get(10) || lists.get(8)!=lists.get(11))){
            return false;
        }
        if(lists.size() == 12)
            return true;
        if(lists.size() == 10 && (lists.get(8)!=lists.get(3) || lists.get(9)!=lists.get(4))){
            return false;
        }
        if(lists.size() == 8 && (lists.get(6)!=lists.get(1) || lists.get(7)!=lists.get(2))){
            return false;
        }
            for(int i=0;i<dom.length-1;i=i+2){
                if(!visited[i]){
                    visited[i] = true;
                    lists.add(dom[i]);
                    lists.add(dom[i+1]);
                    if(domino(dom,i+2,lists,visited))
                        return true;
                    lists.remove(lists.size()-1);
                    lists.remove(lists.size()-1);

                    lists.add(dom[i+1]);
                    lists.add(dom[i]);
                    if(domino(dom,i+2,lists,visited))
                        return true;
                    lists.remove(lists.size()-1);
                    lists.remove(lists.size()-1);
                    visited[i] = false;
                }
            }
            return false;
    }
}

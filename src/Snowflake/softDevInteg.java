package Snowflake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class softDevInteg {
    static int count = 0;
    public static void main(String[] args) {
        softDevInteg obj = new softDevInteg();
        obj.teamForm(3,2,4, new char[]{'D','T'},new ArrayList<Character>());System.out.println(count);count=0;
        obj.teamForm(2,2,2, new char[]{'D','T'},new ArrayList<Character>());System.out.println(count);count=0;
        obj.teamForm(2,2,5, new char[]{'D','T'},new ArrayList<Character>());System.out.println(count);count=0;
        obj.teamForm(2,2,7, new char[]{'D','T'},new ArrayList<Character>());System.out.println(count);count=0;
        obj.teamForm(2,2,11, new char[]{'D','T'},new ArrayList<Character>());System.out.println(count);count=0;
        obj.teamForm(3,4,1, new char[]{'D','T'},new ArrayList<Character>());System.out.println(count);count=0;
        obj.teamForm(3,4,2, new char[]{'D','T'},new ArrayList<Character>());System.out.println(count);count=0;
        obj.teamForm(3,4,3, new char[]{'D','T'},new ArrayList<Character>());System.out.println(count);count=0;

    }
    public void teamForm(int d, int t, int q,char[] type, List<Character> list){
        if(list.size()==q && backTrack(d,t,list) ){
            //System.out.println(list);
            count++;
            return;
        }
        for(int i=0;i<type.length;i++){
            if(backTrack(d,t,list)) {
                list.add(type[i]);
                teamForm(d,t,q,type,list);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean backTrack(int d, int t, List<Character> list){
        if(list.size()==0)
            return true;
        int constraint = 0; int count = 0;
        char type = list.get(list.size()-1);
        if(type == 'D')
            constraint = d;
        else
            constraint = t;
        for(int i = list.size()-1;i>=0;i--){
            if(list.get(i)==type)
                count++;
            else
                return true;
            if(count>=constraint)
                return false;
        }
        return true;
    }
}

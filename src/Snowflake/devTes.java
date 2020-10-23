//package Snowflake;
//
//import java.util.*;
//
//public class devTes {
//    public static void main(String[] args) {
//        devTes obj = new devTes();
//        obj.teamform(3,2,11,new ArrayList<Character>());
//    }
//    public int teamform(int d, int t, int q, List<Character> list){
//
//
//        if(backtrack(d,t,list)){
//            list.add('D');
//
//        }
//        if(backtrack(d,t,list)){
//            list.add('T');
//
//        }
//    }
//    public boolean backtrack(int d, int t, List<Character> list){
//        if(list.size()==0)
//            return true;
//        int constraint = 0; int count = 0;
//        char type = list.get(list.size()-1);
//        if(type == 'D')
//            constraint = d;
//        else
//            constraint = t;
//        for(int i = list.size()-1;i>=0;i--){
//            if(list.get(i)==type)
//                count++;
//            else
//                return true;
//            if(count>=constraint)
//                return false;
//        }
//        return true;
//    }
//
//}

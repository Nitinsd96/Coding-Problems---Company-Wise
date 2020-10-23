//import java.util.*;
//
//public class wayfair {
//       static String div(int A,int B,int C){
//            Map<String,Integer> hash1 = new HashMap<String,Integer>();
//            hash1.put("a",A);
//            hash1.put("b",B);
//            hash1.put("c",C);
//            String str ="";
//            System.out.println(hash1);
//
//           HashMap<String,Integer> hash =sortByValue(hash1);
//
//
//           while((hash.get('a')!=0 && hash.get('b')!=0) ||
//                   (hash.get('a')!=0 && hash.get('c')!=0) || (hash.get('b')!=0 && hash.get('c')!=0)){
//                    for(Map.Entry<String,Integer> entry : hash.entrySet()){
//                        if(entry.getValue()>1){
//                            str=str + entry.getKey()+entry.getKey();
//                            hash.put(entry.getKey(),entry.getValue()-2);
//                            continue;
//                        }
//                        if(entry.getValue()==1){
//                            str=str + entry.getKey();
//                            hash.put(entry.getKey(),entry.getValue()-1);
//                            break;
//                        }
//                    }
//           }
//           if(hash.get('a')>0){
//               if(hash.get('a')>1){
//                   str=str + "a"+"a";
//               }
//               else{
//                   str=str + "a";
//               }
//           }
//           if(hash.get('b')>0){
//               if(hash.get('b')>1){
//                   str=str + "b"+"b";
//               }
//               else{
//                   str=str + String.valueOf('b');
//               }
//           }if(hash.get('c')>0){
//               if(hash.get('c')>1){
//                   str=str + "c"+"c";
//               }
//               else{
//                   str=str + "c";
//               }
//           }
//       return str;}
//
//    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
//    {
//        // Create a list from elements of HashMap
//        List<Map.Entry<String, Integer> > list =
//                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
//
//        // Sort the list
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
//            public int compare(Map.Entry<String, Integer> o1,
//                               Map.Entry<String, Integer> o2)
//            {
//                return (o1.getValue()).compareTo(o2.getValue());
//            }
//        });
//
//        // put data from sorted list to hashmap
//        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
//        for (Map.Entry<String, Integer> aa : list) {
//            temp.put(aa.getKey(), aa.getValue());
//        }
//        return temp;
//    }
//
//
//    public static void main(String[] args) {
//        System.out.println(div(0,1,8));
//        int temp[][] = {[1,2],[2,3]};
//        Map<int[],Integer> hash = new HashMap<int[], Integer>();
//        hash.put(temp[0],1);
//    }
//}

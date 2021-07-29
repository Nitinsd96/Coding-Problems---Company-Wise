package Coupang;

import java.util.*;

public class bigram {
    public static void main(String[] args) {
        bigram pbj = new bigram();

        String s = "this is too big";
        List<String> sym = new ArrayList<>(Arrays.asList("big,large"));

        String s1 = "i am fed up with you";
        List<String> sym1 = new ArrayList<>(Arrays.asList("fed up,annoyed"));


        pbj.bigram(s,sym);
        pbj.bigram(s1,sym1);
    }
    public List<String> bigram(String s,List<String> syn){
        List<String> result = new ArrayList<>();
        Map<String,String> hash = new HashMap<>();
        Set<String> donttake = new HashSet();
        for ( String st : syn){

            String[] temp = st.split(",");
            String[] keystemp = temp[0].split(" ");
            donttake.add(temp[0]);
            if(keystemp.length>1) {
                hash.put(keystemp[0],temp[1]);
                hash.put(keystemp[1],temp[1]);
            }
            hash.put(temp[0],temp[1]);
        }
        String[] words = s.split(" ");
        for(int i=0;i<words.length-1;i++){
            result.add(words[i] + " " + words[i + 1]);
            if(!donttake.contains(words[i]+" "+words[i+1])) {
                if (hash.containsKey(words[i]))
                    result.add(words[i] + " " + hash.get(words[i]));
                if (hash.containsKey(words[i+1]))
                    result.add(words[i]+" "+hash.get(words[i+1]) );
            }
        }
        if(hash.containsKey(words[words.length-1]))
            result.add(words[words.length-2]+" "+hash.get(words[words.length-1]));
        Collections.sort(result);
        System.out.println(result);
        return result;
    }

}

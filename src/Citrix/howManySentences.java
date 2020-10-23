package Citrix;
import java.util.*;
public class howManySentences {
    public static void main(String[] args) {
        howManySentences obj = new howManySentences();
        List<String> wordSet = new ArrayList<>(Arrays.asList("listen","silent","it","is"));
        List<String> sentences = new ArrayList<>(Arrays.asList("listen it is silent lentsi"));

        System.out.println(obj.countSentences(wordSet,sentences)); //4

        List<String> wordSet1 = new ArrayList<>(Arrays.asList("the","bats","tabs","in","cat","act"));
        List<String> sentences1 = new ArrayList<>(Arrays.asList("cat the bats ","in the act","act tabs in"));

        System.out.println(obj.countSentences(wordSet1,sentences1)); //4,2,4

        List<String> wordSet2 = new ArrayList<>(Arrays.asList("star", "tars", "stay", "tay", "seed", "dees", "eesd", "rast", "date", "ate"));
        List<String> sentences2 = new ArrayList<>(Arrays.asList("ate date stay", "rast tay star"));

        System.out.println(obj.countSentences(wordSet2,sentences2)); //1,9
    }
    public static List<Long> countSentences(List<String> wordSet,List<String> sentences) {
        List<Long> reesult = new ArrayList();
        Map<String, Integer> hash = new HashMap();
        for (String word : wordSet) {
                char[] temp = word.toCharArray();
                Arrays.sort(temp);
                String add = String.valueOf(temp);
                hash.put(add, hash.getOrDefault(add, 0) + 1);
        }
        //System.out.println(hash);
        for (String sentence : sentences) {
            String[] S = sentence.split(" ");
            int count = 1;
            for (String word : S) {
                if(wordSet.contains(word)){
                    char[] temp = word.toCharArray();
                    Arrays.sort(temp);
                    String add = String.valueOf(temp);
                    if (hash.containsKey(add) && hash.get(add) > 1) {
                        count = count*hash.get(add);
                    }
                }
            }
            reesult.add((long) count);
        }
        return reesult;
    }
}

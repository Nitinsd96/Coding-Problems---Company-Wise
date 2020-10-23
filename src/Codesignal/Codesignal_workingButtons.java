package Codesignal;

import java.util.*;

public class Codesignal_workingButtons {
    public static void main(String[] args) {
        int[] digits = {2,3};
        String[] words = {"abc","gdef"};
        int[] digits1 = {0,1,2,3,4,5,6,7,8,9};
        String[] words1 = {"abc","gdef","x"};

        Codesignal_workingButtons obj = new Codesignal_workingButtons();
        obj.workingButtons(digits,words);
        obj.workingButtons(digits1,words1);
    }
    public Boolean[] workingButtons(int[] digits, String[] words){
        Set<Character> alpha = new HashSet<>();
        Boolean[] result = new Boolean[words.length];
        for(int i=0;i< digits.length;i++){
            if(digits[i]==2){
                alpha.add('a');
                alpha.add('b');
                alpha.add('c');
            }
            if(digits[i]==3){
                alpha.add('d');
                alpha.add('e');
                alpha.add('f');
            }
            if(digits[i]==4){
                alpha.add('g');
                alpha.add('h');
                alpha.add('i');
            }
            if(digits[i]==5){
                alpha.add('j');
                alpha.add('k');
                alpha.add('l');
            }
            if(digits[i]==6){
                alpha.add('m');
                alpha.add('n');
                alpha.add('o');
            }
            if(digits[i]==7){
                alpha.add('p');
                alpha.add('q');
                alpha.add('r');
            }
            if(digits[i]==8){
                alpha.add('s');
                alpha.add('t');
                alpha.add('u');
            }
            if(digits[i]==9){
                alpha.add('w');
                alpha.add('x');
                alpha.add('y');
                alpha.add('z');
            }
        }
        System.out.println(alpha);
        int k =0;boolean flag = false;
        for(String word : words){
            flag = false;
            for(int i = 0;i<word.length();i++){
                if(!alpha.contains(word.charAt(i))){
                    flag = true;
                    result[k] = false;
                    break;
                }
            }
            if(!flag)
                result[k] = true;
            k++;
        }
        System.out.println(Arrays.toString(result));
        return result;

    }
}

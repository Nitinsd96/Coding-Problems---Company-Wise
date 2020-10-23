package Blackrock.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String[] splittedInput = line.split(";");
            //inputs ;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32
            //b;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32
            String pattern = splittedInput[0];
            String blobs = splittedInput[1];
            Main.doSomething(pattern, blobs);
        }
    }
    public static void doSomething(String pattern, String blobs) {
        // Write your code here. Feel free to create more methods and/or classes
        String[] blobsArray = blobs.split("\\|");
        int patternLength = pattern.length();
        int count = 0;
        int total = 0;
        String out = "";
        System.out.println(patternLength);
        for(String blob : blobsArray){
            count = 0;
            for(int i=0;i+patternLength<blob.length();i++){
                //System.out.println(blob.substring(i,i+patternLength));
                if(blob.substring(i,i+patternLength).compareTo(pattern)==0 && !pattern.isEmpty()){
                    count++;
                }
            }
            //System.out.println(count);
            total += count;
            out =   out + Integer.toString(count) + "|";
            System.out.println(out);
        }
        out = out + Integer.toString(total);
        System.out.println(out);
    }
}

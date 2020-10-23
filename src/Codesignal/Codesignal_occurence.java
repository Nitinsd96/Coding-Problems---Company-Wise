package Codesignal;

public class Codesignal_occurence {
    public static void main(String[] args) {
        String ss= "abcdefghi";
        System.out.println(ss.substring(0,3));
        Codesignal_occurence obj = new Codesignal_occurence();
        System.out.println(obj.countOccurence(10));
        System.out.println(obj.countOccurence(22));
    }
    public int countOccurence(int n){
        int num =0; int count=0;
        for(int i=0;i<=n;i++){
            int number = i;
            while(number!=0){
                num = number%10;
                number=number/10;
                if(num == 2 || num == 4 || num == 0){
                    count++;
                }
            }
        }
        return count+1;
    }
}
